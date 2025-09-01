package boot.start.servlet;

import boot.start.domain.Users;
import boot.start.repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/userlogin/*")
public class UserLoginServlet extends HttpServlet {

    UsersRepository usersRepository = UsersRepository.getInstance();

    /** 기본 로그인 폼 (아이디/이름 입력) */
    private void renderLoginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String error = req.getParameter("error"); // ?error=1 형태로 메시지 표시용

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Login</title></head><body>");
        out.println("<h1>로그인</h1>");
        if ("1".equals(error)) {
            out.println("<p style='color:red'>admin이 아니면 회원가입 페이지로 이동합니다.</p>");
        }
        out.println("<form action='" + req.getContextPath() + "/userlogin' method='post'>");
        out.println("  <label for='userId'>User ID:</label><br>");
        out.println("  <input type='text' id='userId' name='userId' required><br><br>");
        out.println("  <label for='userName'>User Name:</label><br>");
        out.println("  <input type='text' id='userName' name='userName' required><br><br>");
        out.println("  <input type='submit' value='확인'>");
        out.println("</form>");
        out.println("<p><a href='" + req.getContextPath() + "/userlogin/register'>회원가입 페이지로 이동</a></p>");
        out.println("</body></html>");
    }

    /** 회원가입 폼 (필드 채워서 등록) */
    private void renderRegisterForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        // login에서 넘어온 값이 있다면 유지해주기
        String userId = req.getParameter("userId") == null ? "" : req.getParameter("userId");
        String userName = req.getParameter("userName") == null ? "" : req.getParameter("userName");

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>User Registration</title></head><body>");
        out.println("<h1>회원가입</h1>");
        out.println("<form action='" + req.getContextPath() + "/userlogin/register' method='post'>");
        out.println("  <label for='userId'>User ID:</label><br>");
        out.println("  <input type='text' id='userId' name='userId' value='" + userId + "' required><br><br>");
        out.println("  <label for='userName'>User Name:</label><br>");
        out.println("  <input type='text' id='userName' name='userName' value='" + userName + "' required><br><br>");
        out.println("  <input type='submit' value='Register'>");
        out.println("</form>");
        out.println("<p><a href='" + req.getContextPath() + "/userlogin'>로그인으로 돌아가기</a></p>");
        out.println("</body></html>");
    }

    /** 프로필 페이지 (세션 필요) */
    private void renderProfile(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("loginUser") == null) {
            // 로그인 안 되어 있으면 로그인 폼으로
            resp.sendRedirect(req.getContextPath() + "/userlogin");
            return;
        }

        Users loginUser = (Users) session.getAttribute("loginUser");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Profile</title></head><body>");
        out.println("<h1>프로필</h1>");
        out.println("<p>User ID: " + loginUser.getUserId() + "</p>");
        out.println("<p>User Name: " + loginUser.getUserName() + "</p>");
        out.println("<p><a href='" + req.getContextPath() + "/userlogin/list'>회원 목록 보기</a></p>");
        out.println("<p><a href='" + req.getContextPath() + "/userlogin/logout'>로그아웃</a></p>");
        out.println("</body></html>");
    }

    /** 등록 사용자 목록(JSON) */
    private void handleApiList(HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json;charset=UTF-8");
        List<Users> allUsers = usersRepository.findAll();
        PrintWriter writer = resp.getWriter();
        // ObjectMapper가 List를 이미 [ ... ] 형태로 직렬화하므로 별도 대괄호 출력 불필요
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(allUsers);
        writer.write(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();
        if (path == null) path = "/";

        switch (path) {
            case "/profile":
                renderProfile(req, resp);
                return;
            case "/register":
                renderRegisterForm(req, resp);
                return;
            case "/list":
                handleApiList(resp);
                return;
            case "/logout": {
                HttpSession session = req.getSession(false);
                if (session != null) session.invalidate();
                resp.sendRedirect(req.getContextPath() + "/userlogin");
                return;
            }
            // (선택) 데모용: /login 접속 시 admin 자동 로그인
            case "/login": {
                HttpSession session = req.getSession(true);
                if (session.getAttribute("loginUser") == null) {
                    Users admin = new Users();
                    admin.setUserId("admin");
                    admin.setUserName("admin");
                    session.setAttribute("loginUser", admin);
                    usersRepository.save(admin);
                }
                resp.sendRedirect(req.getContextPath() + "/userlogin/profile");
                return;
            }
            default:
                // 기본: 로그인 폼
                renderLoginForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path == null) path = "/";

        // POST 본문 한글 대비
        req.setCharacterEncoding("UTF-8");

        switch (path) {
            // 회원가입 처리
            case "/register": {
                String userId = trim(req.getParameter("userId"));
                String userName = trim(req.getParameter("userName"));

                Users user = new Users();
                user.setUserId(userId);
                user.setUserName(userName);
                usersRepository.save(user);

                resp.setContentType("text/html;charset=UTF-8");
                PrintWriter writer = resp.getWriter();
                writer.println("<!DOCTYPE html>");
                writer.println("<html><head><title>User Registered</title></head><body>");
                writer.println("<h1>회원가입 완료</h1>");
                writer.println("<p>User ID: " + user.getUserId() + "</p>");
                writer.println("<p>User Name: " + user.getUserName() + "</p>");
                writer.println("<a href='" + req.getContextPath() + "/userlogin'>로그인으로 돌아가기</a> | ");
                writer.println("<a href='" + req.getContextPath() + "/userlogin/list'>전체 회원 목록</a>");
                writer.println("</body></html>");
                return;
            }
            // 로그인 판단(여기서 admin이면 프로필, 아니면 회원가입 페이지로 이동)
            default: {
                String userId = trim(req.getParameter("userId"));
                String userName = trim(req.getParameter("userName"));

                if ("admin".equals(userId) && "admin".equals(userName)) {
                    //admin인 경우: 세션 로그인 + 프로필로
                    HttpSession session = req.getSession(true);
                    Users admin = new Users();
                    admin.setUserId("admin");
                    admin.setUserName("admin");
                    session.setAttribute("loginUser", admin);

                    // (선택) admin을 저장소에 없으면 등록
                    usersRepository.save(admin);

                    resp.sendRedirect(req.getContextPath() + "/userlogin/profile");
                } else {
                    String qUserId = URLEncoder.encode(userId, StandardCharsets.UTF_8);
                    String qUserName = URLEncoder.encode(userName, StandardCharsets.UTF_8);
                    resp.sendRedirect(req.getContextPath() + "/userlogin/register?userId=" + qUserId + "&userName=" + qUserName);
                }
                return;
            }
        }
    }

    private static String trim(String s) {
        return s == null ? "" : s.trim();
    }
}

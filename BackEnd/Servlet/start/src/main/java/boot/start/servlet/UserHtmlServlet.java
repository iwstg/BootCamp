package boot.start.servlet;

import boot.start.domain.Users;
import boot.start.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="UserHtmlServlet", urlPatterns = {"/userhtml","/userhtml/list"})
public class UserHtmlServlet extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

    //html
    private void handleUserFrom(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>User Registration</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Register New User</h1>");
        out.println("<form action='/userhtml' method='post'>");
        out.println("    <label for='userId'>User ID:</label><br>");
        out.println("    <input type='text' id='userId' name='userId'><br><br>");
        out.println("    <label for='userName'>User Name:</label><br>");
        out.println("    <input type='text' id='userName' name='userName'><br><br>");
        out.println("    <input type='submit' value='Register'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String Path = req.getPathInfo();
        System.out.println("Path: " + Path);

        if("/list".equals(Path)){
            handleApiList(resp);
        }else {
            handleUserFrom(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{

        System.out.println("doPost 실행");

        String userId = req.getParameter("userId");
        String userName = req.getParameter("userName");

        // user 객체로
        Users user = new Users();
        user.setUserId(userId);
        user.setUserName(userName);

        userRepository.save(user);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html><head><title>User Registered</title></head><body>");
        writer.println("<h1>User Registered Successfully!</h1>");
        writer.println("<p>User ID: " + user.getUserId() + "</p>");
        writer.println("<p>User Name: " + user.getUserName() + "</p>");
        writer.println("<a href='/userhtml/list'>전체 회원 목록 보기</a>");
        writer.println("</body></html>");
    }

    // 등록 사용자 조회
    private void handleApiList(HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");

        List<Users> allUsers = userRepository.findAll();

        PrintWriter out = resp.getWriter();
        out.println("[");

        for (int i = 0; i < allUsers.size(); i++) {
            Users u = allUsers.get(i);
            out.print("  {\"userId\": \"" + u.getUserId() + "\", \"userName\": \"" + u.getUserName() + "\"}");
            if (i < allUsers.size() - 1) {
                out.println(","); // 마지막 요소가 아니면 쉼표 추가
            } else {
                out.println();
            }
        }

        out.println("]");
    }

}

package boot.start.practice.domainpractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/domain/user") // 브라우저나 Postman에서 /domain/user 요청이 오면 이 서블릿이 실행됨
public class UserServlet extends HttpServlet {

    // ✅ 회원 정보를 저장할 "가짜 DB"
    // static: 서버가 켜져 있는 동안 모든 요청이 이 리스트를 공유한다.
    private static final List<User> users = new ArrayList<>();

    // ✅ JSON <-> 객체 변환을 도와주는 Jackson 라이브러리
    private final ObjectMapper objectMapper = new ObjectMapper();

    // ======================= POST 요청 처리 =======================
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1. 요청의 Body(본문)에 있는 JSON 데이터를 읽는다.
        String jsonBody = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        // 2. JSON 문자열 -> User 객체로 변환
        //    {"userId":"test1","userName":"홍길동"} → new User("test1","홍길동")
        User user = objectMapper.readValue(jsonBody, User.class);

        // 3. 변환된 User 객체를 "가짜 DB" (users 리스트)에 저장
        users.add(user);

        // 4. 결과를 HTML로 응답
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>회원 등록 성공!</h2>");
        out.println("<p>ID: " + user.getUserId() + "</p>");
        out.println("<p>Name: " + user.getUserName() + "</p>");
        out.println("<a href='/user'>회원 목록 보기</a>");
        out.println("</body></html>");
    }

    // ======================= GET 요청 처리 =======================
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 1. 응답을 HTML 형식으로 설정
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // 2. 지금까지 저장된 회원 목록을 HTML로 출력
        out.println("<html><body>");
        out.println("<h2>회원 목록</h2>");
        out.println("<ul>");
        for (User user : users) { // users 리스트를 돌면서
            out.println("<li>" + user.getUserId() + " - " + user.getUserName() + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
}
package boot.start.servlet;

import boot.start.domain.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "apiServlet", urlPatterns = "/api")
public class ApiServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req,  HttpServletResponse resp)
        throws ServletException, IOException {

        // Json Body 읽어오기
        String msgBody = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        System.out.println("msgBody = " + msgBody);

        // Json -> User 객체 변환
        Users user = objectMapper.readValue(msgBody, Users.class);
        System.out.println("userId = " + user.getUserId());
        System.out.println("userName = " + user.getUserName());

        // User 객체 -> json
        resp.setContentType("application/json; charset=UTF-8");
        String result = objectMapper.writeValueAsString(user);
        resp.setContentType("application/json");
        resp.getWriter().println(result);


    }
}

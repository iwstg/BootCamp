package boot.start.servlet;

import boot.start.domain.Users;
import boot.start.repository.UsersRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/usercheck")
public class UserCheckServlet extends HttpServlet {

    UsersRepository usersRepository = UsersRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Users> users = usersRepository.findAll();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("[");

        for (int i = 0; i < users.size(); i++) {
            Users u = users.get(i);
            out.print("  {\"userId\": \"" + u.getUserId() + "\", \"userName\": \"" + u.getUserName() + "\"}");
            if (i < users.size() - 1) {
                out.println(","); // 마지막 요소가 아니면 쉼표 추가
            } else {
                out.println();
            }
        }

        out.println("]");

    }
}

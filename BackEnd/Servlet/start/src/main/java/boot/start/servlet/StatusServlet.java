package boot.start.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/statustest")
public class StatusServlet extends HttpServlet {
    @Override
    protected void  doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException{
        res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        res.setContentType("text/plain;charset=utf-8");
        res.getWriter().println("응답이 정상적으로 처리되었습니다.");
    }
}

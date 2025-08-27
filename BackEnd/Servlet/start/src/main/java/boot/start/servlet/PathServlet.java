package boot.start.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/path")
public class PathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException{

        String servletPath = req.getServletPath();
        String contextPath = req.getContextPath();

        res.setContentType("text/plain;charset=utf-8");
        res.getWriter().println("servletPath: "+servletPath);
        res.getWriter().println("contextPath: "+contextPath);

    }
}

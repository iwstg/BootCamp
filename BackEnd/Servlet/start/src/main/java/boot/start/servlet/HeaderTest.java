package boot.start.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headertest")
public class HeaderTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = req.getHeader(headerName);
            System.out.println(headerName + ": " + headerValue);
        }

        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");
        res.setHeader("Custom-Header", "custom header !!");


        res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        res.setHeader("Pragma", "no-cache"); // HTTP를 1.0으로 하위호환 하겠다
        res.setDateHeader("Expires", 0); // 만료되게 만듦

        res.getWriter().println("<h1>응답 헤더 설정</h1>");


    }
}

package boot.start.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Cookie[] cookies = req.getCookies();
        boolean found = false;

        if(cookies != null){
            for(Cookie c : cookies){
                if("user".equals(c.getName())){
                    out.println(c.getValue());
                    found = true;
                    break;
                }
            }
        }
        if(!found){
            out.println("<h2>N o Cookie </h2>");
            Cookie newCookie = new Cookie("user","아아");
            newCookie.setMaxAge(30);
            resp.addCookie(newCookie);
        }
    }
}

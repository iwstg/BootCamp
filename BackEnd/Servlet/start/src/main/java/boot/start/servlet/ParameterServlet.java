package boot.start.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.PreparedStatement;

@WebServlet("/param-test")
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        // getParameter (/param-test?name=홍길동&hobby=축구&hobby=농구)
        String name = req.getParameter("name");
        String[] hobbies = req.getParameterValues("hobby");

        String method = req.getMethod();
        String userAgent = req.getHeader("User-Agent");

        String uri = req.getRequestURI();
        StringBuffer url = req.getRequestURL();
        String query = req.getQueryString();
        String protocol = req.getProtocol();

        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();
        String locale = req.getLocale().toString();
        String ip = req.getRemoteAddr(); // 게시판 조회수 증가 시 ip주소로 체크 가능
        int port = req.getRemotePort();

        res.setContentType("text/plain;charset=utf-8");
        res.getWriter().println("요청메서드: "+ method);
        res.getWriter().println("이름: "+ name);
        if(hobbies != null) {
            for(String h : hobbies) {
                res.getWriter().println("취미 리스트: "+ h);
            }
        }
        res.getWriter().println("User_Agent: "+ userAgent);

        res.getWriter().println("URI: "+ uri);
        res.getWriter().println("URL: "+ url);
        res.getWriter().println("QUERY: "+ query);
        res.getWriter().println("PROTOCOL: "+ protocol);
        if(cookies != null) {
            for(Cookie c : cookies) {
                res.getWriter().println("쿠키: "+ c.getName() + "=" + c.getValue());
            }
        }
        res.getWriter().println("세션ID: "+ session);
        res.getWriter().println("세션ID: "+ session.toString().substring(session.toString().indexOf("@") + 1));
        res.getWriter().println("Locale: "+ locale);
        res.getWriter().println("Ip: "+ ip);
        res.getWriter().println("Port: "+ port);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String encoding = req.getCharacterEncoding();
        int length = req.getContentLength();

        res.setContentType("text/plain;charset=utf-8");
        res.getWriter().println("인코딩: "+ encoding);
        res.getWriter().println("본문길이: "+ length);

        ServletInputStream inputStream = req.getInputStream();
        byte[] buffer = inputStream.readAllBytes();
        String body = new String(buffer, encoding != null ? encoding : "UTF-8");

        res.getWriter().println("본문내용: "+ body);

        BufferedReader reader = req.getReader();
        String bufferbody = reader.readLine();

        req.setAttribute("msg", "Forward로 전달한 메세지");
/*
        // 0827 기준 result.jsp 파일이 생성되어야하는데, 아직 jsp를 배우지 않았으니 이후에 배울 예정
        RequestDispatcher dispatcher = req.getRequestDispatcher("/result.jsp");
        dispatcher.forward(req, res);
*/


    }
}

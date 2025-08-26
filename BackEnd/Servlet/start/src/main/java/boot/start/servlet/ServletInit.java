package boot.start.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="servletInitServlet", urlPatterns = "/request")
public class ServletInit extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        System.out.println("request");
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        System.out.println("일반적인 for loop를 통해 데이터 호출");
        System.out.println("복수 파라미터 조회");
        String[] userIds = req.getParameterValues("userId");
        if(userIds != null) {
            for (String userId : userIds) {
                System.out.println("userId" + " = " + userId);
            }
        }
        System.out.println("단일 파라미터 조회");
        String userId = req.getParameter("userId");
        System.out.println("userId = " + userId);
        super.doGet(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        System.out.println("---- HTTP POST Method ----");

        System.out.println("복수 파라미터 조회");
        String[] names = req.getParameterValues("userId");
        if (names != null) {
            for (String name : names) {
                System.out.println("name = " + name);
            }
        } else {
            System.out.println("No name parameters found.");
        }

        String age = req.getParameter("age");
        System.out.println("age = " + age);
        super.doPost(req, res);
    }
}

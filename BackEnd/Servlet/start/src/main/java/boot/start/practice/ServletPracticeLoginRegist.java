/**
 * 2025-08-27 과제 코드
 * 회원가입(POST)와 로그인(GET) 구현하기
 *
 * 회원가입 (POST) 구조 정의
 * 요청 경로: /user
 * 요청 파라미터: username (아이디), password (비밀번호), email (이메일)
 * 결과값: 성공 시 "회원가입 완료: username" 출력, 상태코드 201 create 반환
 *
 * 로그인 (GET) 구조 정의
 * 요청 경로: /user?username=aaa&password=1234
 * 요청 파라미터: username (아이디), password(비밀번호)
 * 결과값: 성공 시 상태코드 200 OK 반환과 유저정보 출력, 실패 시 상태코드 401 Unauthorized 반환
 */

package boot.start.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/user")
public class ServletPracticeLoginRegist extends HttpServlet {

    HashMap<String, String> repository = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(repository.get(username) != null && repository.get(username).equals(password)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("<h1>로그인 계정: " + username + "님 안녕하세요</h1>");
        }else{
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("<h1>로그인 오류 - 존재하지 않는 아이디 이거나 패스워드가 일치하지 않습니다.</h1>");
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String eamil = req.getParameter("email");

        if(username != null && password != null) {
            repository.put(username, password);

            resp.setContentType("text/plain;charset=utf-8");
            resp.getWriter().println("회원가입 완료: " + username);
            resp.setStatus(HttpServletResponse.SC_OK);
        }else{
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("<h1>로그인 오류 - 존재하지 않는 아이디 이거나 패스워드가 일치하지 않습니다.</h1>");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

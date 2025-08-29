package boot.start.practice.postmanageprogram;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet(name="PostServlet", urlPatterns = {"/practice/post","/practice/post/list"}) > 이렇게 사용 시 getPathInfo가 null이 나옴
@WebServlet("/practice/post/*")
public class PostServlet extends HttpServlet {
    static final PostRepository repo = new PostRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String Path = req.getPathInfo();

        if(req.getParameter("postIdx") != null) {
            long postidx = Long.valueOf(req.getParameter("postIdx"));
            handleDirectPost(postidx, resp);
        }else if(req.getParameter("keyword") != null) {
            handleSerchConetent(req.getParameter("keyword"), resp);
        }else if ("/list".equals(Path)) {
            handlePostList(resp);
        } else {
            handlePosts(resp);
        }
    }

    // 게시글 등록 페이지
    protected void handlePosts(HttpServletResponse resp)
        throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-08-29 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시글 관리 프로그램 만들기</h1>");
        out.println("<form action='/practice/post' method='post'>");
        out.println("    <label for='title'>게시글 제목: </label><br>");
        out.println("    <input type='text' id='title' name='title'><br><br>");
        out.println("    <textarea id='content' name='content' rows=10 cols=50 placeholder='여기에 글을 입력하세요...'></textarea><br><br>");
        out.println("    <input type='submit' value='등록'>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    // 게시글 전체 보기
    protected void handlePostList(HttpServletResponse resp)
        throws IOException {
        List<Post> allPosts = repo.findAll();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-08-29 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>게시글 목록</h1>");
        for (Post p : allPosts) {
            out.print("<a href='/practice/post/list?postIdx=" + p.getPostIdx() + "'>[ "+p.getPostIdx()+" ] - 제목 : " + p.getTitle() + " 작성일: "+ p.getTime() +"</a><br>");
        }
        out.println("<br><a href='/practice/post'>글 작성하러 가기</a><br>");
        out.println("<form action='/practice/post' method='get'>");
        out.println("   <label for='keyword'>검색:</label>");
        out.println("   <input type='text' id='keyword' name='keyword'></input>");
        out.println("   <input type='submit' value='검색'></input>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    // 선택한 게시글 내용 조회
    protected void handleDirectPost(long idx, HttpServletResponse resp)
        throws IOException {
        Post post = repo.findByPostIdx(idx);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-08-29 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>제목: "+post.getTitle()+"</h1>");
        out.println("<h2>내용: "+post.getContent()+"</h2>");
        out.println("<h2>작성일: "+post.getTime()+"</h2>");
        out.println("<br><a href='/practice/post/list'>글 목록보러 가기</a><br>");
        out.println("<br><a href='/practice/post'>글 작성하러 가기</a><br>");
        out.println("</body>");
        out.println("</html>");
    }

    // 검색한 내용을 포함하는 게시글 조회
    protected void handleSerchConetent(String keyword, HttpServletResponse resp)
        throws IOException{
        List<Post> allPosts = repo.findAll();
        List<Post> searchedPosts = allPosts.stream()
                .filter(p -> p.getContent().contains(keyword))
                .toList();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-08-29 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>\""+ keyword +"\" 검색 결과</h1>");
        for (Post p : searchedPosts) {
            out.print("<p>[ "+p.getPostIdx()+" ] - 제목 : " + p.getTitle() + " ("+ p.getTime()+")</p>");
            out.print("<p>"+p.getContent()+"</p><br><br>");
        }
        out.println("<br><a href='/practice/post/list'>글 목록보러 가기</a><br>");
        out.println("<br><a href='/practice/post'>글 작성하러 가기</a><br>");
        out.println("<form action='/practice/post' method='get'>");
        out.println("   <label for='keyword'>검색:</label>");
        out.println("   <input type='text' id='keyword' name='keyword'></input>");
        out.println("   <input type='submit' value='검색'></input>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Post post = new Post();
        post.setTitle(req.getParameter("title"));
        post.setContent(req.getParameter("content"));
        repo.save(post);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html><head><title>2025-08-29 과제</title></head><body>");
        writer.println("<h1>게시물이 등록되었습니다.</h1>");
        writer.println("<p>게시글 번호: " + post.getPostIdx() + "</p>");
        writer.println("<p>게시글 제목: " + post.getTitle() + "</p>");
        writer.println("<p>게시글 내용: " + post.getContent() + "</p>");
        writer.println("<p>게시글 작성일: " + post.getTime() + "</p>");
        writer.println("<a href='/practice/post/list'>전체 게시글 목록 보기</a><br>");
        writer.println("<a href='/practice/post'>추가 글 등록하기</a>");
        writer.println("</body></html>");
    }

}

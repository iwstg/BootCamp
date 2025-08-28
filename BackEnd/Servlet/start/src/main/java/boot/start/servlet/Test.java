package boot.start.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@WebServlet("/test")
public class Test extends HttpServlet {

    private static final String ETAG = "v1.0";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /*
        // 1) 캐시 컨트롤
        resp.setHeader("Cache-Control", "max-age=3600, public");
        resp.setDateHeader("Expires", System.currentTimeMillis() + 3600);
        resp.setContentType("text/plain; charset=utf-8");
        resp.getWriter().println("캐시 응답 예제 (1시간 동안 캐시됨)");

        // 2)
        String clientEtag = req.getHeader("If-None-Match");
        if(ETAG.equals(clientEtag)) {
            resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
            return;
        }
        resp.setHeader("ETag", ETAG);
        resp.setContentType("text/paine; charset=utf-8");
        resp.getWriter().println("최신 데이터 버전: " + ETAG);

        3) Thread.sleep ms 이후 동작
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>첫번째 데이터</h1>");

        resp.flushBuffer();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        writer.println("두번째 데이터");
        writer.println("</body></html>");


        String fileName = "sample.txt";
        String fileContent = "This is download file";

        resp.setContentType("application/octet-stream"); // 파일 다운로드는 octet-stream
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        OutputStream out = resp.getOutputStream();
        out.write(fileContent.getBytes());
        out.flush();
        out.close();
        */
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+name + age+"</h1>");
        out.println("</body></html>");
    }
}

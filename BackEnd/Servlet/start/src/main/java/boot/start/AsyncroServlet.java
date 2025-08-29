package boot.start;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/asyncro", asyncSupported = true)
public class AsyncroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //비동기 처리 시작
        final AsyncContext asyncContext = req.startAsync();

        asyncContext.start(()->{
            try {
                Thread.sleep(3000);
                HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
                response.setContentType("text/html;charset=utf-8");

                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h1>비동기 작업 완료</h1>");
                out.println("</body></html>");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                asyncContext.complete();
            }
        });


    }
}

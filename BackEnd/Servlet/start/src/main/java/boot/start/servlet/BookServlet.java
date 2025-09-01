package boot.start.servlet;

import boot.start.domain.Book;
import boot.start.repository.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = {"/books", "/books/create", "/books/update", "/books/delete", "/books/list"})
public class BookServlet extends HttpServlet {

    BookRepository repo = BookRepository.getInstance();

    // 메인 페이지 ( 책 목록 출력 )
    protected void listBooks(HttpServletRequest req, HttpServletResponse resp)
            throws IOException{
        List<Book> books = repo.findAll().stream().toList();
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-09-01 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table><caption> 책 목록 </caption><thead><tr><th>[ 책 번호 ]</th><th> [ 책 이름 ]</th><th> [ 출판사 ]</th><th> [ 판매가 ]</th><th> [ 대여료 ]</th><th> [ 대여자 ]</th><th> [ 등록일시 ]</th><th> [ 수정일시 ]</th><th> [ 편집 ]</th></tr></thead>");
        out.println("<tbody>");
        for(Book book : books){
            out.println("<tr><th>"+book.getId()+"</th><th>"+book.getTitle()+"</th><th>"+book.getPublisher()+"</th><th>"+book.getSalePrice()+"</th><th>"+book.getRentalPrice()+"</th><th>"+book.getRenter()+"</th><th>"+book.getRegistrationDate()+"</th><th>"+book.getUpdateDate()+"</th><th>[ <a href='/books/update?bookId="+book.getId()+"'>수정</a> <a href='/books/delete?bookId="+book.getId()+"'>삭제</a> ]</th>");
        }
        out.println("</tbody></table>");
        out.println("<a href='/books/create'>책 등록하러 가기</a><br>");
        out.println("</body>");
        out.println("</html>");
    }

    // 게시글 등록 페이지
    protected void showCreateForm(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-09-01 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> 책 정보 입력</h1>");
        out.println("<form action='/books/create' method='post'>");
        out.println("   <label for='title'>책 제목: </label>");
        out.println("   <input type='text' id='title' name='title' required><br>");
        out.println("   <label for='publisher'>출판사: </label>");
        out.println("   <input type='text' id='publisher' name='publisher' required><br>");
        out.println("   <label for='salePrice'>판매가: </label>");
        out.println("   <input type='text' id='salePrice' name='salePrice' required><br>");
        out.println("   <label for='rentalPrice'>대여료: </label>");
        out.println("   <input type='text' id='rentalPrice' name='rentalPrice' required><br>");
        out.println("   <label for='renter'>대여자: </label>");
        out.println("   <input type='text' id='renter' name='renter'><br>");
        out.println("   <input type='submit' value='생성'>");
        out.println("</form>");
        out.println("<a href='/books/list'>책 목록 보러가기</a>");
        out.println("</body>");
        out.println("</html>");
    }

    // 책 정보 업데이트 페이지
    protected void showUpdateForm(HttpServletRequest req, HttpServletResponse resp, Long bookId)
            throws IOException {
        Book book = repo.findById(bookId).orElse(null);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-09-01 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> 책 수정 페이지</h1>");
        out.println("<form action='/books/update' method='post'>");
        out.println("   <input type='hidden' name='bookId' value='" + book.getId() + "'/>");
        out.println("   <label for='title'>책 제목: </label>");
        out.println("   <input type='text' id='title' name='title' value='"+book.getTitle()+"'><br>");
        out.println("   <label for='publisher'>출판사: </label>");
        out.println("   <input type='text' id='publisher' name='publisher' value='"+book.getPublisher()+"'><br>");
        out.println("   <label for='salePrice'>판매가: </label>");
        out.println("   <input type='text' id='salePrice' name='salePrice' value='"+book.getSalePrice()+"'><br>");
        out.println("   <label for='rentalPrice'>대여료: </label>");
        out.println("   <input type='text' id='rentalPrice' name='rentalPrice' value='"+book.getRentalPrice()+"'><br>");
        out.println("   <label for='renter'>대여자: </label>");
        out.println("   <input type='text' id='renter' name='renter' value='"+book.getRenter()+"'><br>");
        out.println("   <input type='submit' value='변경'>");
        out.println("</form>");
        out.println("<a href='/books/list'>변경을 취소하고 책 목록 보러가기</a>");
        out.println("</body>");
        out.println("</html>");

    }

    // 책 정보 삭제
    protected void deleteBook(HttpServletRequest req, HttpServletResponse resp, long bookId)
            throws IOException {
        Book book = repo.findById(bookId).orElse(null);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta http-equiv='refresh' content='2;url=/books/list'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-09-01 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> 책 \""+book.getTitle()+"\"이(가) 정상적으로 삭제됐습니다. </h1>");
        out.println("<h2>잠시 후, 조회 화면으로 이동합니다...</h2>");
        out.println("</body>");
        out.println("</html>");
        repo.delete(bookId);
    }

    @Override
    protected void doGet(HttpServletRequest req,  HttpServletResponse resp)
        throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/books/create":
                showCreateForm(req, resp);
                break;
            case "/books/update":
                try{
                    showUpdateForm(req, resp, Long.parseLong(req.getParameter("bookId")));
                }catch(NullPointerException e){
                    ErrorPage(resp);
                }
                break;
            case "/books/delete":
                try{
                    deleteBook(req, resp, Long.parseLong(req.getParameter("bookId")));
                }catch(NullPointerException e){
                    ErrorPage(resp);
                }
                break;
            case "/books/list":
            default:
                listBooks(req, resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req,  HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getServletPath();
        switch(action){
            case "/books/create":
                createBook(req, resp);
                break;
            case "/books/update":
                updateBook(req, resp);
                break;
            default:
                listBooks(req, resp);
                break;
        }
    }

    // 책 생성 Post 요청
    protected void  createBook(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Book book = new Book();
        try{
            book.setSalePrice(Double.parseDouble(req.getParameter("salePrice")));
            book.setRentalPrice(Double.parseDouble(req.getParameter("rentalPrice")));
            if(req.getParameter("title").isEmpty() || req.getParameter("publisher").isEmpty()){
                ErrorPage(resp);
                return;
            }
        }catch (NumberFormatException | NullPointerException n){
            ErrorPage(resp);
            return ;
        }

        book.setTitle(req.getParameter("title"));
        book.setPublisher(req.getParameter("publisher"));
        book.setRenter(req.getParameter("renter"));
        repo.save(book);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta http-equiv='refresh' content='2;url=/books/list'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-09-01 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> 책 \""+book.getTitle()+"\"이(가) 정상적으로 등록됐습니다. </h1>");
        out.println("<h1> 출판사: "+book.getPublisher()+", 판매가: "+book.getSalePrice()+" 원, 대여료: "+book.getRentalPrice()+" 원 </h1>");
        out.println("<h2>잠시 후, 조회 화면으로 이동합니다...</h2>");
        out.println("</body>");
        out.println("</html>");
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

    // 책 수정 Post 요청
    protected void updateBook(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        long bookId = Long.parseLong(req.getParameter("bookId"));
        Book book = repo.findById(bookId).orElse(null);

        try{
            book.setSalePrice(Double.parseDouble(req.getParameter("salePrice")));
            book.setRentalPrice(Double.parseDouble(req.getParameter("rentalPrice")));
            if(req.getParameter("title").isEmpty() || req.getParameter("publisher").isEmpty()){
                ErrorPage(resp);
                return;
            }
        }catch (NumberFormatException | NullPointerException n){
            ErrorPage(resp);
            return ;
        }
        book.setTitle(req.getParameter("title"));
        book.setPublisher(req.getParameter("publisher"));
        book.setSalePrice(Double.parseDouble(req.getParameter("salePrice")));
        book.setRentalPrice(Double.parseDouble(req.getParameter("rentalPrice")));
        book.setRenter(req.getParameter("renter"));
        book.setUpdateDate(LocalDate.now());
        repo.update(bookId, book);

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta http-equiv='refresh' content='2;url=/books/list'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-09-01 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> 책 \""+book.getTitle()+"\"이(가) 정상적으로 수정됐습니다. </h1>");
        out.println("<h1> 출판사: "+book.getPublisher()+", 판매가: "+book.getSalePrice()+" 원, 대여료: "+book.getRentalPrice()+" 원 </h1>");
        out.println("<h2>잠시 후, 조회 화면으로 이동합니다...</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    // 에러페이지. (정상적인 접근 아닐 경우)
    protected void ErrorPage(HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<meta http-equiv='refresh' content='2;url=/books/list'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>2025-09-01 과제</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 style='color:red'> 비정상 접근 입니다. </h1>");
        out.println("<h2>잠시 후, 조회 화면으로 이동합니다...</h2>");
        out.println("</body>");
        out.println("</html>");
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }

}

package boot.start.practice.domainpractice;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    // ✅ 회원 정보를 저장할 "가짜 DB"
    // static: 서버가 켜져 있는 동안 모든 요청이 이 리스트를 공유한다.
    private static final List<Product> products = new ArrayList<>();

    // ✅ JSON <-> 객체 변환을 도와주는 Jackson 라이브러리
    private final ObjectMapper objectMapper = new ObjectMapper();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String minPrice = req.getParameter("minPrice");
        String productID = req.getParameter("productID");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>상품 목록</h2>");
        out.println("<ul>");
        if(productID == null) {
            for (Product p : products) {
                if (minPrice == null || p.getPrice() >= Integer.parseInt(minPrice))
                    out.println("<li> 상품ID - <b>" + p.getProductId() + "</b>, 상품명: <b>" + p.getProductName() + "</b> 가격: <b>" + p.getPrice() + "</b>원</li>");
            }
        }else{
            for (Product p : products) {
                if(p.getProductId().equals(productID) && (minPrice == null || p.getPrice() >= Integer.parseInt(minPrice))) {
                    out.println("<li> 상품ID - <b>" + p.getProductId() + "</b>, 상품명: <b>" + p.getProductName() + "</b> 가격: <b>" + p.getPrice() + "</b>원</li>");
                }
            }
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String jsonBody = new String(req.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        Product product = objectMapper.readValue(jsonBody, Product.class);
        products.add(product);
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>상품 등록완료</h1>");
        out.println("<p>상품ID: " + product.getProductId() + "</p>");
        out.println("<p>상품명: " + product.getProductName() + "</p>");
        out.println("<p>가격: " + product.getPrice() + "</p>");
        out.println("</body></html>");
        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

}

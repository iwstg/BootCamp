package com.udemy.mvc.controller;

import com.udemy.mvc.service.BookService;
import com.udemy.mvc.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/validation")
public class VlidationController {
    private final BookService bookService;

    @PostMapping("/books") // postman에서 http://localhost:8080/validation/books
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        // 제목
        if(book.getTitle() == null || book.getTitle().trim().isEmpty()){
            return ResponseEntity.badRequest().body("{ \"error\":\"책 제목은 필수 입력값입니다. \"}");
        }

        // 출판사
        if(book.getPublisher() == null || book.getPublisher().trim().isEmpty()){
            return ResponseEntity.badRequest().body("{ \"error\":\"출판사는 필수 입력값입니다. \"}");
        }

        // 가격
        if(book.getSalePrice() < 0){
            return ResponseEntity.badRequest().body("{ \"error\":\"가격은 0원 이상이어야 합니다. \"}");
        }

        Book createBook = bookService.createBook(book);
        log.info("Book created: {}", createBook);

        return ResponseEntity.ok(createBook);
    }
}

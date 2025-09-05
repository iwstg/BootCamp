package com.udemy.mvc.controller;

import com.udemy.mvc.Service.BookService;
import com.udemy.mvc.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // CREATE: 책 생성
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        try {
            Book created = bookService.createBook(book);
            log.info("Book created: {}", created.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (IllegalArgumentException e) {
            log.warn("Create book validation error: {}", e.getMessage());
            return ResponseEntity.badRequest().body(errorMsg(e.getMessage()));
        }
    }

    // READ: 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Optional<Book> bookOpt = bookService.getBookById(id);
        return bookOpt.<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(errorMsg("책을 찾을 수 없습니다.")));
    }

    // READ: 전체 조회
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // UPDATE: 책 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(errorMsg("책을 찾을 수 없습니다.")));
    }

    // DELETE: 책 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        return deleted
                ? ResponseEntity.ok(msg("책이 성공적으로 삭제되었습니다."))
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorMsg("책을 찾을 수 없습니다."));
    }

    // BOOKING: 대여
    @PostMapping("/{id}/rent/{userIdx}")
    public ResponseEntity<?> rentBook(@PathVariable Long id, @PathVariable Long userIdx) {
        try {
            Optional<Book> rented = bookService.rentBook(id, userIdx);
            return rented.<ResponseEntity<?>>map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(errorMsg("책을 찾을 수 없습니다.")));
        } catch (IllegalStateException | IllegalArgumentException e) {
            log.error("대여 에러: {}", e.getMessage());
            return ResponseEntity.badRequest().body(errorMsg(e.getMessage()));
        }
    }

    // RETURN: 반납
    @PostMapping("/{id}/return/{userIdx}")
    public ResponseEntity<?> returnBook(@PathVariable Long id, @PathVariable Long userIdx) {
        try {
            Optional<Book> returned = bookService.returnBook(id, userIdx);
            return returned.<ResponseEntity<?>>map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(errorMsg("책을 찾을 수 없습니다.")));
        } catch (IllegalStateException | IllegalArgumentException e) {
            log.error("반납 에러: {}", e.getMessage());
            return ResponseEntity.badRequest().body(errorMsg(e.getMessage()));
        }
    }

    // ===== 공통 응답 헬퍼 =====
    private static String msg(String message) {
        return String.format("{\"message\":\"%s\"}", message);
    }

    private static String errorMsg(String message) {
        return String.format("{\"error\":\"%s\"}", message);
    }
}

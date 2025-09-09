package com.udemy.mvc.controller;

import com.udemy.mvc.service.BookService;
import com.udemy.mvc.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/validation/form")
public class ValidationFormContoller {
    private final BookService bookService;

    @GetMapping("/books") // http://localhost:8080/validation/form/books
    public String showBookForm(Model model){
        model.addAttribute("book", new Book());
        return "validation/bookForm";
    }

    @PostMapping("/books") // http://localhost:8080/validation/form/books
    public String createBook(@ModelAttribute Book book, Model model){

        // 제목
        if(book.getTitle() == null || book.getTitle().trim().isEmpty()){
            model.addAttribute("error", "책 제목은 필수 입력값입니다.");
            model.addAttribute("book", book);
            return "validation/bookForm";
        }

        // 출판사
        if(book.getPublisher() == null || book.getPublisher().trim().isEmpty()){
            model.addAttribute("error", "저자/출판사는 필수 입력값입니다.");
            model.addAttribute("book", book);
            return "validation/bookForm";
        }

        // 가격
        if(book.getSalePrice() < 0){
            model.addAttribute("error", "책 가격은 0 이상이어야 합니다.");
            model.addAttribute("book", book);
            return "validation/bookForm";
        }

        Book createdBook = bookService.createBook(book);
        model.addAttribute("book", createdBook);
        model.addAttribute("success", "책이 성공적으로 등록되었습니다.");
        return "validation/bookForm";
    }
}

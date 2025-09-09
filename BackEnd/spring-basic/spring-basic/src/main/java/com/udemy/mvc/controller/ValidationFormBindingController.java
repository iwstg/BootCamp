package com.udemy.mvc.controller;

import com.udemy.mvc.service.BookService;
import com.udemy.mvc.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/validation/form/binding")
public class ValidationFormBindingController {

    private final BookService bookService;

    @GetMapping("/books") // http://localhost:8080/validation/form/binding/books
    public String showForm(Model model){
        model.addAttribute("book", new Book());
        return "validation/bookFormBinding";
    }

    @PostMapping("/books")
    public String create(
            @ModelAttribute("book") Book book,
            BindingResult bindingResult, // 순서 중요함. ModelAttribute 바로 뒤에서 와야함
            Model model) {

        if (!StringUtils.hasText(book.getTitle())) {
            bindingResult.rejectValue("title", "error.title", "책 제목은 필수 입력값입니다.");
        }
        if (!StringUtils.hasText(book.getPublisher())) {
            bindingResult.rejectValue("publisher", "error.title", "출판사는 필수 입력값입니다.");
        }
        if (book.getSalePrice() < 0) {
            bindingResult.rejectValue("salePrice", "error.title", "책 가격은 0 이상이어야 합니다.");
        }

        Book created = bookService.createBook(book);
        log.info("Book created: {}", created);
        model.addAttribute("success", "등록완료");
        return "validation/bookFormBinding";
    }
}


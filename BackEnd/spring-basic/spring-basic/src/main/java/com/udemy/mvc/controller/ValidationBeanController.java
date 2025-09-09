package com.udemy.mvc.controller;

import com.udemy.mvc.service.BookService;
import com.udemy.mvc.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/validation/bean")
public class ValidationBeanController {

    private final BookService bookService;

    @GetMapping("/books") // http://localhost:8080/validation/bean/books
    public String showForm(Model model){
        model.addAttribute("book", new Book());
        return "validation/bookBean";
    }

    @PostMapping("/books")
    public String create(
            @Validated
            @ModelAttribute("book") Book book,
            BindingResult bindingResult, // 순서 중요함. ModelAttribute 바로 뒤에서 와야함
            Model model) {

        if(bindingResult.hasErrors()){
            log.info("Validation error = {}", bindingResult);
            return "validation/bookBean";
        }

        Book created = bookService.createBook(book);
        log.info("Book created: {}", created);
        model.addAttribute("success", "등록완료");
        return "validation/bookBean";
    }
}


package com.udemy.mvc.controller;

import com.udemy.mvc.dto.BookUpdateForm;
import com.udemy.mvc.service.BookService;
import com.udemy.mvc.domain.Book;
import com.udemy.mvc.validate.BookCreate;
import com.udemy.mvc.dto.BookCreateForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/validation/dtobean")
public class ValidationBeanFormController {

    private final BookService bookService;

    @InitBinder // 컨트롤러에서 바인드 규칙 설명
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Double.class, new CustomNumberEditor(Double.class,true));
    }

    @GetMapping("/books") // http://localhost:8080/validation/dtobean/books
    public String showForm(Model model){
        model.addAttribute("book", new Book());
        return "validation/bookCreate";
    }

    @PostMapping("/books")
    public String create(
            @Valid
            @ModelAttribute("book") BookCreateForm form,
            BindingResult bindingResult, // 순서 중요함. ModelAttribute 바로 뒤에서 와야함
            Model model) {

        if(bindingResult.hasErrors()){
//            log.info("Validation error = {}", bindingResult);
            return "validation/bookCreate";
        }

        Book newBook = new Book();
        newBook.setTitle(form.getTitle());
        newBook.setPublisher(form.getPublisher());
        newBook.setSalePrice(form.getSalePrice());

        Book created = bookService.createBook(newBook);
        log.info("Book created: {}", created);
        model.addAttribute("success", "등록완료");
        return "validation/bookCreate";
    }

    @GetMapping("/books/{id}/edit") // http://localhost:8080/validation/dtobean/books/id/edit
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.getBookById(id);

        // 책을 찾지 못한 경우
        if (book.isEmpty()) {
            model.addAttribute("error", "책을 찾을 수 없습니다.");
            return "validation/bookUpdate";
        }

        // 엔티티 → DTO 변환 (수정폼에 기존 값 채워 넣음)
        BookUpdateForm form = new BookUpdateForm();
        form.setId(book.get().getId());
        form.setTitle(book.get().getTitle());
        form.setPublisher(book.get().getPublisher());

        model.addAttribute("book", form);
        return "validation/bookUpdate"; // templates/validation/bookUpdate.html
    }

    @PostMapping("/books/{id}/update")
    public String updateBook(
        @PathVariable("id") Long bookId,
        @Valid @ModelAttribute("book") BookUpdateForm form,
        BindingResult bindingResult,
        Model model) {

        if (bindingResult.hasErrors()) {
            return "validation/bookUpdate";
        }

        Optional<Book> bookOpt = bookService.getBookById(bookId);
        if (bookOpt.isEmpty()) {
            model.addAttribute("error", "해당 책을 찾을 수 없습니다.");
            return "validation/bookUpdate";
        }

        Book patch = new Book();
        patch.setTitle(form.getTitle());
        patch.setPublisher(form.getPublisher());

        Optional<Book> updated = bookService.updateBook(bookId, patch);
        if (updated.isPresent()) {
            model.addAttribute("success", "책이 성공적으로 수정되었습니다.");
            BookUpdateForm rebound = new BookUpdateForm();
            rebound.setId(updated.get().getId());
            rebound.setTitle(updated.get().getTitle());
            rebound.setPublisher(updated.get().getPublisher());
            model.addAttribute("book", rebound);
        } else {
            model.addAttribute("error", "책 수정에 실패했습니다.");
        }

        return "validation/bookUpdate";
    }
}


package com.udemy.mvc.Service;

import com.udemy.mvc.domain.Book;
import com.udemy.mvc.domain.User;
import com.udemy.mvc.repository.BookRepository;
import com.udemy.mvc.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    /* ===== CRUD ===== */
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> updateBook(Long id, Book patch) {
        return bookRepository.update(id, patch);
    }

    public boolean deleteBook(Long id) {
        return bookRepository.delete(id);
    }


    /* ===== RENT / RETURN ===== */
    // 도서 대여: 책 존재 → 대여중 여부 → 사용자 존재 → renter에 사용자 이름 기록
    public Optional<Book> rentBook(Long bookId, Long userIdx) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (bookOpt.isEmpty()) throw new IllegalArgumentException("책을 찾을 수 없습니다.");

        Book book = bookOpt.get();
        if (book.getRenter() != null && !book.getRenter().isEmpty()) {
            throw new IllegalStateException("이 책은 이미 대여 중입니다.");
        }

        Optional<User> userOpt = userRepository.findByUserIdx(userIdx);
        if (userOpt.isEmpty()) throw new IllegalArgumentException("유효하지 않은 사용자입니다.");

        book.setRenter(userOpt.get().getUserName());
        return bookRepository.update(bookId, book);
    }
    // 도서 반납: 책 존재 → 대여중인지 → 반납요청자=대여자 확인 → renter 비우기
    public Optional<Book> returnBook(Long bookId, Long userIdx) {
        Optional<Book> bookOpt = bookRepository.findById(bookId);
        if (bookOpt.isEmpty()) throw new IllegalArgumentException("책을 찾을 수 없습니다.");

        Book book = bookOpt.get();
        if (book.getRenter() == null || book.getRenter().isEmpty()) {
            throw new IllegalStateException("이 책은 대여 중이 아닙니다.");
        }

        Optional<User> userOpt = userRepository.findByUserIdx(userIdx);
        if (userOpt.isEmpty()) throw new IllegalArgumentException("유효하지 않은 사용자입니다.");

        String requesterName = userOpt.get().getUserName();
        if (!requesterName.equals(book.getRenter())) {
            throw new IllegalArgumentException("반납 요청자가 실제 대여자와 일치하지 않습니다.");
        }

        book.setRenter(null);
        return bookRepository.update(bookId, book);
    }
}
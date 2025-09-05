package com.udemy.mvc.repository;

import com.udemy.mvc.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Repository
public class BookRepository {

    private final ConcurrentMap<Long, Book> bookMap = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(0L);

    // CREATE
    public Book save(Book book) {
        long id = seq.incrementAndGet();
        book.setId(id);
        if (book.getRegistrationDate() == null) book.setRegistrationDate(LocalDate.now());
        book.setUpdateDate(LocalDate.now());
        bookMap.put(id, book);
        return book;
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(bookMap.get(id));
    }

    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    // UPDATE (부분 수정: 숫자 필드는 전달값으로 덮어씀, 문자열은 null 아닐 때만 변경)
    public Optional<Book> update(Long id, Book patch) {
        Book exist = bookMap.get(id);
        if (exist == null) return Optional.empty();

        // 문자열은 null 아닐 때만 갱신
        if (patch.getTitle() != null) exist.setTitle(patch.getTitle());
        if (patch.getPublisher() != null) exist.setPublisher(patch.getPublisher());

        // 숫자형(double)은 값 전달 시 그대로 덮어쓰기
        exist.setSalePrice(patch.getSalePrice());
        exist.setRentalPrice(patch.getRentalPrice());

        // renter는 서비스 로직(대여/반납)에서 주로 변경하지만, patch로도 덮어쓰기 허용
        exist.setRenter(patch.getRenter());
        exist.setUpdateDate(LocalDate.now());
        bookMap.put(id, exist);
        return Optional.of(exist);
    }

    public boolean delete(Long id) {
        return bookMap.remove(id) != null;
    }
}
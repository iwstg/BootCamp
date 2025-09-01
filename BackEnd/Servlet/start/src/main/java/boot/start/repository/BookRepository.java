package boot.start.repository;

import boot.start.domain.Book;
import boot.start.domain.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BookRepository {
    // 싱글톤 인스턴스
    private static final BookRepository instances = new BookRepository();
    private BookRepository() {}
    public static BookRepository getInstance() {
        return instances;
    }

    private final ConcurrentMap<Long, Book> bookMap = new ConcurrentHashMap<>();
    private static Long bookId = 0L;


    public Book save(Book book) {
        book.setId(++bookId);
        book.setRegistrationDate(LocalDate.now());
        book.setUpdateDate(LocalDate.now());
        bookMap.put(book.getId(), book);
        return book;
    }

    public Optional<Book> findById(long id) { return Optional.ofNullable(bookMap.get(id)); }

    public List<Book> findAll() {
        return new ArrayList<>(bookMap.values());
    }

    public boolean delete(Long id) {
        return bookMap.remove(id) != null;
    }

    public Optional<Book> update(Long id, Book updateBook) {
        if(bookMap.containsKey(id)) {
            updateBook.setId(id);
            bookMap.put(id, updateBook);
            return Optional.of(updateBook);
        }
        return Optional.empty();
    }
}

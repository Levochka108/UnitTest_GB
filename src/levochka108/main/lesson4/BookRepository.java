package levochka108.main.lesson4;

import java.util.List;

public interface BookRepository {
    Book findById(long id);
    List<Book> findAll();
    void save(Book book);
    void delete(long id);
}
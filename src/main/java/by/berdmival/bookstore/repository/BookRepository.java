package by.berdmival.bookstore.repository;

import by.berdmival.bookstore.entity.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

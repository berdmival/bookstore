package by.berdmival.bookstore.repository;

import by.berdmival.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

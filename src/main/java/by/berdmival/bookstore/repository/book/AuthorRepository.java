package by.berdmival.bookstore.repository.book;

import by.berdmival.bookstore.entity.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}

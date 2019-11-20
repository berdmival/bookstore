package by.berdmival.bookstore.repository.book;

import by.berdmival.bookstore.entity.book.Author;
import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.entity.book.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> getBooksByAuthorsContains(Author author);

    List<Book> getBooksByGenresContains(Genre genre);
}

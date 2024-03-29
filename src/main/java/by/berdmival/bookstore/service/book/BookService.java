package by.berdmival.bookstore.service.book;

import by.berdmival.bookstore.entity.book.Author;
import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.entity.book.Genre;

import java.util.List;

public interface BookService {
    Book saveOne(Book book);

    List<Book> saveSeveral(List<Book> books);

    List<Book> findAll();

    Book findById(Long id);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByGenre(Genre genre);

    void deleteOne(Book book);

    void deleteOneById(Long id);
}

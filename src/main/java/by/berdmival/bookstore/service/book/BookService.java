package by.berdmival.bookstore.service.book;

import by.berdmival.bookstore.entity.book.Book;

import java.util.List;

public interface BookService {
    Book saveOne(Book book);

    List<Book> saveSeveral(List<Book> books);

    List<Book> findAll();

    List<Book> findBooksByAuthorId(Long authorId);

    List<Book> findBooksByGenreId(Long genreId);
}

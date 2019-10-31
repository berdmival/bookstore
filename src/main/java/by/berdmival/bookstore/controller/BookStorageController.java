package by.berdmival.bookstore.controller;

import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.service.book.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BookStorageController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping(path = "/books")
    List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping(path = "/books/author/{authorId}")
    List<Book> getBooksByAuthorId(@PathVariable("authorId") Long authorId) {
        return bookService.findBooksByAuthorId(authorId);
    }

    @GetMapping(path = "/books/genre/{genreId}")
    List<Book> getBooksByGenreId(@PathVariable("genreId") Long genreId) {
        return bookService.findBooksByAuthorId(genreId);
    }

}

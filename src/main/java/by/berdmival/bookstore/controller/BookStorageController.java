package by.berdmival.bookstore.controller;

import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.service.book.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStorageController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping(path = "/books")
    ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping(path = "/books")
    ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveOne(book));
    }

    @PutMapping(path = "/books/{bookId}")
    ResponseEntity<Book> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveOne(book));
    }

    @GetMapping(path = "/books/author/{authorId}")
    ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable("authorId") Long authorId) {
        return ResponseEntity.ok(bookService.findBooksByAuthorId(authorId));
    }

    @GetMapping(path = "/books/genre/{genreId}")
    ResponseEntity<List<Book>> getBooksByGenreId(@PathVariable("genreId") Long genreId) {
        return ResponseEntity.ok(bookService.findBooksByGenreId(genreId));
    }

}

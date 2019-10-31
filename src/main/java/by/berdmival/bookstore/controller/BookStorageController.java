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
    ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") Long bookId) {
        book.setId(bookId);
        return ResponseEntity.ok(bookService.saveOne(book));
    }

    @GetMapping(path = "/books/{bookId}")
    ResponseEntity<Book> getBookById(@PathVariable("bookId") Long bookId) {
        Book book = bookService.findById(bookId);
        if (book.getId() == bookId) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/books/{bookId}")
    void deleteBookById(@PathVariable("bookId") Long bookId) {
        bookService.deleteOneById(bookId);
    }

    @DeleteMapping(path = "/books")
    void deleteBook(@RequestBody Book book) {
        bookService.deleteOne(book);
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

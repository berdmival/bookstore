package by.berdmival.bookstore.controller;

import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.service.book.AuthorService;
import by.berdmival.bookstore.service.book.BookService;
import by.berdmival.bookstore.service.book.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookStorageController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;
    @Autowired
    private AuthorService authorService;

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping(path = "/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveOne(book));
    }

    @PutMapping(path = "/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") Long bookId) {
        book.setId(bookId);
        return ResponseEntity.ok(bookService.saveOne(book));
    }

    @GetMapping(path = "/books/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId") Long bookId) {
        Book book = bookService.findById(bookId);
        if (book.getId() == bookId) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/books/{bookId}")
    public void deleteBookById(@PathVariable("bookId") Long bookId) {
        bookService.deleteOneById(bookId);
    }

    @DeleteMapping(path = "/books")
    public void deleteBook(@RequestBody Book book) {
        bookService.deleteOne(book);
    }

    @GetMapping(path = "/books/author/{authorId}")
    public ResponseEntity<List<Book>> getBooksByAuthorId(@PathVariable("authorId") Long authorId) {
        return ResponseEntity.ok(bookService.findBooksByAuthor(authorService.findById(authorId)));
    }

    @GetMapping(path = "/books/genre/{genreId}")
    public ResponseEntity<List<Book>> getBooksByGenreId(@PathVariable("genreId") Long genreId) {
        return ResponseEntity.ok(bookService.findBooksByGenre(genreService.findById(genreId)));
    }

}

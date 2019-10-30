package by.berdmival.bookstore.controller;

import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.service.book.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookStorageController {

    @Autowired
    BookServiceImpl bookService;

    @GetMapping(path = "/books")
    List<Book> getAllBooks() {
        return bookService.findAll();
    }


}

package by.berdmival.bookstore.service.book;

import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
@Repository
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveOne(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> saveSeveral(List<Book> books) {
        return (List<Book>) bookRepository.saveAll(books);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }
}

package by.berdmival.bookstore.service.book;

import by.berdmival.bookstore.entity.book.Book;
import by.berdmival.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("bookService")
@Repository
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book saveOne(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> saveSeveral(List<Book> books) {
        return bookRepository.saveAll(books);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> searchResult = bookRepository.findById(id);
        if (searchResult.isPresent()) {
            return searchResult.get();
        } else {
            return new Book();
        }
    }

    @Override
    public List<Book> findBooksByAuthorId(Long authorId) {
        return bookRepository.findBooksByAuthorId(authorId);
    }

    @Override
    public List<Book> findBooksByGenreId(Long genreId) {
        return bookRepository.findBooksByGenreId(genreId);
    }

    @Override
    public void deleteOne(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteOneById(Long id) {
        bookRepository.deleteById(id);
    }
}

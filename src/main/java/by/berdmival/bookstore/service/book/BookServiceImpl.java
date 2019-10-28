package by.berdmival.bookstore.service.book;

import by.berdmival.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;
}

package by.berdmival.bookstore.service.book;

import by.berdmival.bookstore.entity.book.Author;

import java.util.List;

public interface AuthorService {
    Author saveOne(Author author);

    List<Author> saveSeveral(List<Author> authors);

    List<Author> findAll();

    Author findById(Long id);

    void deleteOne(Author author);

    void deleteOneById(Long id);
}

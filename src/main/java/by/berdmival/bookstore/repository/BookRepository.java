package by.berdmival.bookstore.repository;

import by.berdmival.bookstore.entity.book.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM BOOKS WHERE ID IN (SELECT BOOK_ID FROM BOOKS_AUTHORS WHERE AUTHOR_ID = ?1)")
    List<Book> findBooksByAuthorId(Long authorId);

    @Query(nativeQuery = true,
            value = "SELECT * FROM BOOKS WHERE ID IN (SELECT BOOK_ID FROM BOOKS_GENRES WHERE GENRE_ID = ?1)")
    List<Book> findBooksByGenreId(Long genreId);
}

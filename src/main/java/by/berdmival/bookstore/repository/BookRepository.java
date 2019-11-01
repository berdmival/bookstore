package by.berdmival.bookstore.repository;

import by.berdmival.bookstore.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select b from Book b join b.authors a where a.id = :authorId")
    List<Book> findBooksByAuthorId(Long authorId);

    @Query(value = "select b from Book b join b.genres g where g.id = :genreId")
    List<Book> findBooksByGenreId(Long genreId);
}

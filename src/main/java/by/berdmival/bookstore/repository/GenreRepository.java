package by.berdmival.bookstore.repository;

import by.berdmival.bookstore.entity.book.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}

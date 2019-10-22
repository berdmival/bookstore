package by.berdmival.bookstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "genres")
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "bookGenres")
    @JoinTable(
            name = "books_authors_relations",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;
}

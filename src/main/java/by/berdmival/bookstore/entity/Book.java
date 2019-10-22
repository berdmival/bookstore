package by.berdmival.bookstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Table(name = "books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private int price;
    private int yearOfPublication;

    @ManyToMany
    @JoinTable(
            name = "books_authors_relations",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<BookAuthor> bookAuthors;

    @ManyToMany
    @JoinTable(
            name = "books_genres_relations",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<BookGenre> bookGenres;
}

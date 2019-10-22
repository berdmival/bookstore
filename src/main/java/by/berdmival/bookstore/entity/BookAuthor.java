package by.berdmival.bookstore.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "authors")
public class BookAuthor {

    @Id
    @GeneratedValue
    private long id;

    private String firstName;
    private String secondName;

    @ManyToMany(mappedBy = "bookAuthors")
    @JoinTable(
            name = "books_authors_relations",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> books;
}

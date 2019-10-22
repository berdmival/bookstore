package by.berdmival.bookstore.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
    private Set<Book> books;
}

package by.berdmival.bookstore.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Table(name = "genres")
public class BookGenre {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany(mappedBy = "bookGenres")
    private Set<Book> books;
}

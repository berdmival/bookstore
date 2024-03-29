package by.berdmival.bookstore.entity.book;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}

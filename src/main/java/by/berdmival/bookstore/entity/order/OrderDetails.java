package by.berdmival.bookstore.entity.order;

import by.berdmival.bookstore.entity.book.Book;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Order order;
    @ManyToOne
    private Book book;

    private int quantity;
}

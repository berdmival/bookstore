package by.berdmival.bookstore.entity.order;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String customerName;
    private Date orderDateTime;

    @OneToMany
    private Set<OrderDetails> orderDetails;
}

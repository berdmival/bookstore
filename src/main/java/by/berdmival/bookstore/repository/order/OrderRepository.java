package by.berdmival.bookstore.repository.order;

import by.berdmival.bookstore.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUsername(String username);
}

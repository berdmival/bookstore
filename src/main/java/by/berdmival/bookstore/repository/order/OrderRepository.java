package by.berdmival.bookstore.repository.order;

import by.berdmival.bookstore.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

package by.berdmival.bookstore.repository.order;

import by.berdmival.bookstore.entity.order.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}

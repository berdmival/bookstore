package by.berdmival.bookstore.service.order;

import by.berdmival.bookstore.entity.order.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    List<Order> getAllByUser(String username);

    Order addOrderForUser(Order order, String username);

    Order update(Order order);
}

package by.berdmival.bookstore.service.order;

import by.berdmival.bookstore.entity.order.OrderStatus;

public interface OrderStatusService {
    OrderStatus getByName(String name);

    OrderStatus getById(int id);
}

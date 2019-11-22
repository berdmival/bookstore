package by.berdmival.bookstore.service.order;

import by.berdmival.bookstore.entity.order.OrderStatus;
import by.berdmival.bookstore.repository.order.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderStatusService")
@Repository
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Override
    public OrderStatus getByName(String name) {
        return orderStatusRepository.findByName(name);
    }

    @Override
    public OrderStatus getById(int id) {
        return orderStatusRepository.getOne(id);
    }
}

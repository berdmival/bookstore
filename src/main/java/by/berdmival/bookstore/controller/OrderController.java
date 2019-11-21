package by.berdmival.bookstore.controller;

import by.berdmival.bookstore.dto.OrderProductDto;
import by.berdmival.bookstore.entity.order.Order;
import by.berdmival.bookstore.entity.order.OrderDetails;
import by.berdmival.bookstore.service.order.OrderDetailsService;
import by.berdmival.bookstore.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderDetailsService orderDetailsService;
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders/all")
    public ResponseEntity<List<Order>> allOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping(path = "/orders")
    public ResponseEntity<List<Order>> getCurrentUserOrders(Principal principal) {
        return ResponseEntity.ok(orderService.getAllByUser(principal.getName()));
    }

    @PostMapping(path = "/orders")
    public ResponseEntity<Order> addOrder(@RequestBody OrderForm form, Principal principal) {
        List<OrderProductDto> orderProductDtoList = form.getProducts();

        Order order = new Order();
        orderService.addOrderForUser(order, principal.getName());

        List<OrderDetails> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : orderProductDtoList) {
            orderProducts.add(orderDetailsService.create(new OrderDetails(order, dto.getBook(), dto.getQuantity())));
        }

        order.setOrderDetails(orderProducts);

        return ResponseEntity.ok(orderService.update(order));
    }

    public static class OrderForm {

        private List<OrderProductDto> products;

        public List<OrderProductDto> getProducts() {
            return products;
        }

        public void setProducts(List<OrderProductDto> products) {
            this.products = products;
        }
    }
}

package tc.men_you.ontimedining.service;

import tc.men_you.ontimedining.models.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order save(Order order);
    List<Order> findByCustomerId(String id);

    Order validate(String id);

    Optional<Order> findById(String id);

    void deleteById(String id);
}

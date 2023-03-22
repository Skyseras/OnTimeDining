package tc.men_you.ontimedining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.men_you.ontimedining.exception.BadRequestException;
import tc.men_you.ontimedining.models.entity.MenuItem;
import tc.men_you.ontimedining.models.entity.Order;
import tc.men_you.ontimedining.repository.OrderRepository;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository repository;
    @Autowired
    MenuItemService menuItemService;


    @Override
    public Order save(Order order) {
        if (order != null) {
                order.getMenuItemsDetail().forEach(detail -> {
                    MenuItem item = menuItemService.findById(detail.getIdMenuItem()).orElse(null);
                    double total = 0;
                    if (item != null) {
                        total = (item.getPrice()) * detail.getCount();
                    }
                    order.setTotalPay(order.getTotalPay() + total);
                });
            if (order.getTotalPay() == 0)
                throw new BadRequestException("List command item not found");
            order.setDateCreate(new Date());
//            if (order.getTypeOrder().equals("Peck Up"))
//                order.setTimeDelivery(Date.from((new Date()).toInstant().plusMillis(1800000)).toString());
//            else
            order.setTimeDelivery((new Date()).getHours() + 2 + " PM");
            order.setStatus(false);
        }
        return repository.insert(order);
    }

    @Override
    public List<Order> findByCustomerId(String id) {
        return repository.findAllByCustomerId(id);
    }

    @Override
    public Order validate(String id) {
        Order order = this.findById(id).orElse(null);
        if (order == null) {
            throw new BadRequestException("Order with this parameter not found");
        }
        order.setStatus(true);
        return repository.save(order);
    }

    @Override
    public Optional<Order> findById(String id) {
        return repository.findById(id);
    }
    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

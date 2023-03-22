package tc.men_you.ontimedining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tc.men_you.ontimedining.models.entity.MenuItem;
import tc.men_you.ontimedining.repository.RestaurantRepository;
import tc.men_you.ontimedining.models.entity.Restaurant;

import java.util.*;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MenuItemService menuItemService;
    @Override
    public Restaurant save(Restaurant restaurant) {
        Set<MenuItem> menuItems = restaurant.getMenuItems();
        restaurant.setMenuItems(new HashSet<>());
        menuItems.forEach(item ->{
            item = menuItemService.save(item);
            restaurant.getMenuItems().add(item);
        });
        return restaurantRepository.insert(restaurant);
    }
    @Override
    public Restaurant update(Restaurant restaurant) {
        Set<MenuItem> menuItems = restaurant.getMenuItems();
        restaurant.setMenuItems(new HashSet<>());
        menuItems.forEach(item ->{
            if (item.getId() == null)
                item = menuItemService.update(item);
            restaurant.getMenuItems().add(item);
        });
        return restaurantRepository.save(restaurant);
    }
    @Override
    public Optional<Restaurant> findById(String id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }


}

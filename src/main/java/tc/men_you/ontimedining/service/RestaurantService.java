package tc.men_you.ontimedining.service;

import tc.men_you.ontimedining.models.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant);

    Optional<Restaurant> findById(String id);

    List<Restaurant> getAll();
}

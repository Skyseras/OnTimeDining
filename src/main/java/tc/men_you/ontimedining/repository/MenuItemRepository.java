package tc.men_you.ontimedining.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tc.men_you.ontimedining.models.entity.MenuItem;

@Repository
public interface MenuItemRepository extends MongoRepository<MenuItem, String> {

}

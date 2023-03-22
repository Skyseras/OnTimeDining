package tc.men_you.ontimedining.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;


@Document("restaurants")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    private String id;
    private String name;
    private String imageStore;
    private String address;
    private String rating;
    private String phone;
    private Set<MenuItem> menuItems;

}

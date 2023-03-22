package tc.men_you.ontimedining.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("menuItem")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    @Id
    private String id;
    private String name;
    private String imageStore;
    private String description;
    private double price;
    private String Category;

}

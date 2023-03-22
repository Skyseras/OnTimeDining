package tc.men_you.ontimedining.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Map;
import java.util.Set;


@Document("order")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private String id;
    @NotNull @NotEmpty
    private String typeOrder;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dateCreate;
    private String timeDelivery;
    @NotNull @NotEmpty
    private String deliveryAddress;
    @Valid
    private Set<MenuItemsDetail> menuItemsDetail;
    private double totalPay = 0;
    private boolean status;
    @NotNull @NotEmpty
    private String customerId;

}

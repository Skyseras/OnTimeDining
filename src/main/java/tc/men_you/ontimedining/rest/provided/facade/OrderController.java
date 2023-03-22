package tc.men_you.ontimedining.rest.provided.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tc.men_you.ontimedining.exception.BadRequestException;
import tc.men_you.ontimedining.models.domain.ResponseObject;
import tc.men_you.ontimedining.models.entity.MenuItem;
import tc.men_you.ontimedining.models.entity.Order;
import tc.men_you.ontimedining.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/order")
public class OrderController {

    @Autowired
    OrderService service;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<ResponseObject<Order>> save(@RequestBody @Valid Order order) {
        Order save = service.save(order);
        ResponseObject<Order> responseObject = new ResponseObject<>(true, "saved order", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/costumer/{id}")
    public ResponseEntity<ResponseObject<List<Order>>> findByCustomerId(@PathVariable String id) {
        List<Order> save = service.findByCustomerId(id);
        ResponseObject<List<Order>> responseObject = new ResponseObject<>(true, "get order by id costumer", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/validate/{id}")
    public ResponseEntity<ResponseObject<Order>> validate(@PathVariable String id) {
        try {
            Order save = service.validate(id);
            ResponseObject<Order> responseObject = new ResponseObject<>(true, "validate order by id", save);
            return new ResponseEntity<>(responseObject, HttpStatus.OK);
        }catch (BadRequestException e){
            ResponseObject<Order> responseObject = new ResponseObject<>(false, e.getMessage(), null);
            return new ResponseEntity<>(responseObject, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ResponseObject<Order>> findById(@PathVariable String id) {
        Order save = service.findById(id).orElse(null);
        ResponseObject<Order> responseObject = new ResponseObject<>(true, "get order by id", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        ResponseObject<Order> responseObject = new ResponseObject<>(true, "delete order by id", null);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

}

package tc.men_you.ontimedining.rest.provided.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tc.men_you.ontimedining.models.domain.ResponseObject;
import tc.men_you.ontimedining.models.entity.Restaurant;
import tc.men_you.ontimedining.service.RestaurantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/restaurant")
//@CrossOrigin(origins = "http://localhost:9090/")
public class RestaurantController {

    @Autowired
    RestaurantService service;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<ResponseObject<Restaurant>> save(@RequestBody @Valid Restaurant restaurant) {
        Restaurant save = service.save(restaurant);
        ResponseObject<Restaurant> responseObject = new ResponseObject<>(true, "saved", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public ResponseEntity<ResponseObject<Restaurant>> update(@RequestBody @Valid Restaurant restaurant) {
        Restaurant save = service.update(restaurant);
        ResponseObject<Restaurant> responseObject = new ResponseObject<>(true, "update", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<ResponseObject<List<Restaurant>>> getAll() {
        List<Restaurant> save = service.getAll();
        ResponseObject<List<Restaurant>> responseObject = new ResponseObject<>(true, "get all", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ResponseObject<Restaurant>> findById(@PathVariable String id) {
        Restaurant save = service.findById(id).orElse(null);
        ResponseObject<Restaurant> responseObject = new ResponseObject<>(true, "get all", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

}

package tc.men_you.ontimedining.rest.provided.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tc.men_you.ontimedining.models.domain.ResponseObject;
import tc.men_you.ontimedining.models.entity.MenuItem;
import tc.men_you.ontimedining.models.entity.Restaurant;
import tc.men_you.ontimedining.service.MenuItemService;
import tc.men_you.ontimedining.service.RestaurantService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("${api.endpoint}/menu-item")
//@CrossOrigin(origins = "http://localhost:9090/")
public class MenuItemController {

    @Autowired
    MenuItemService service;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<ResponseObject<MenuItem>> save(@RequestBody @Valid MenuItem item) {
        MenuItem save = service.save(item);
        ResponseObject<MenuItem> responseObject = new ResponseObject<>(true, "saved", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<ResponseObject<Page<MenuItem>>> getAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Page<MenuItem> save = service.getAll(PageRequest.of(page, size));
        ResponseObject<Page<MenuItem>> responseObject = new ResponseObject<>(true, "get All", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ResponseObject<MenuItem>> findById(@PathVariable String id) {
        MenuItem save = service.findById(id).orElse(null);
        ResponseObject<MenuItem> responseObject = new ResponseObject<>(true, "get item by id", save);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

}

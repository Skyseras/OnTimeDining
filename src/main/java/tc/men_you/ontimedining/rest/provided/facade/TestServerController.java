package tc.men_you.ontimedining.rest.provided.facade;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tc.men_you.ontimedining.models.domain.ResponseObject;
import tc.men_you.ontimedining.models.entity.Restaurant;


@RestController
@RequestMapping("${api.endpoint}/server")
public class TestServerController {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ResponseEntity<ResponseObject<Restaurant>> test() {
        ResponseObject<Restaurant> responseObject = new ResponseObject<>(true, "Server works!!!", null);
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

}

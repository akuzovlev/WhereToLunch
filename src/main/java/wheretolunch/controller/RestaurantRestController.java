package wheretolunch.controller;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wheretolunch.Util.ExistsException;
import wheretolunch.model.HistoryRecord;
import wheretolunch.model.Restaurant;
import wheretolunch.service.RestaurantService;

import javax.servlet.http.HttpServlet;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController extends HttpServlet {

    static final String REST_URL = "/restaurants";

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/withvotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getAll() {
        List<Restaurant> restaurants = restaurantService.getAll();
        if (restaurants.isEmpty()) {
            return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable("id") int id) throws NotFoundException {
        return restaurantService.getWithoutVotes(id);
    }

    @GetMapping("/{id}/withvotes")
    public Restaurant getWithVotes(@PathVariable("id") int id) throws NotFoundException {
        return restaurantService.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        restaurantService.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Restaurant restaurant, @PathVariable("id") int id) throws NotFoundException {
        restaurant.setId(id);
        restaurantService.update(restaurant);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant) {
        Restaurant created = restaurantService.create(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> getAllWithoutVotes() {
        List<Restaurant> restaurants = restaurantService.getAllWithoutVotes();
        if (restaurants.isEmpty()) {
            return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }


    @GetMapping("/history")
    public List<HistoryRecord> getHistory() {
        return restaurantService.getRestaurantsHistory();
    }

    // Convert a predefined exception to an HTTP Status code
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Value not found")
    @ExceptionHandler(NotFoundException.class)
    public void notFound() {
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Value already exists")
    @ExceptionHandler(ExistsException.class)
    public void exists() {
    }

}

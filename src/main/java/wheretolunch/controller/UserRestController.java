package wheretolunch.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import wheretolunch.Util.ExistsException;
import wheretolunch.model.User;
import wheretolunch.service.UserService;

import javax.servlet.http.HttpServlet;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = UserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController extends HttpServlet {

    static final String REST_URL = "/users";

    @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> users() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable("id") int id) throws NotFoundException {
        return userService.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        userService.delete(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody User user, @PathVariable("id") int id) throws NotFoundException {
        user.setId(id);
        userService.update(user);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User user) {
        User created = userService.create(user);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/vote/{id}")
    public ResponseEntity<Void> vote(@PathVariable("id") int id) throws NotFoundException {
        if (userService.vote(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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

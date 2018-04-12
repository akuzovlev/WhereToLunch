package wheretolunch.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import wheretolunch.model.User;
import wheretolunch.service.UserService;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController extends HttpServlet {

/*    static final String REST_URL = "/users";*/

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.getAll();
    }


}

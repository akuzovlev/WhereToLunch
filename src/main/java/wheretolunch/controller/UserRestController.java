package wheretolunch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wheretolunch.model.User;
import wheretolunch.service.UserService;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
@RequestMapping(value = UserRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestController extends HttpServlet {

    static final String REST_URL = "/users";

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<User> users() {
        return userService.getAll();
    }

}

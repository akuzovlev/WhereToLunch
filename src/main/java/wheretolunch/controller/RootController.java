package wheretolunch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wheretolunch.model.Restaurant;
import wheretolunch.model.User;
import wheretolunch.service.RestaurantService;
import wheretolunch.service.UserService;

import javax.servlet.http.HttpServlet;
import java.util.List;


@RestController
@RequestMapping(value = RootController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController extends HttpServlet {

    static final String REST_URL = "/";

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Restaurant> root() {
        return restaurantService.getAll();
    }

    @GetMapping("users")
    public List<User> users() {
        return userService.getAll();
    }

}


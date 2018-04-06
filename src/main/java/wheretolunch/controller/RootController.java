package wheretolunch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wheretolunch.service.RestaurantService;
import wheretolunch.service.UserService;

import javax.servlet.http.HttpServlet;


@Controller
public class RootController extends HttpServlet {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("restaurants", restaurantService.getAll());
        return "voting";
    }

/*    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }*/

}


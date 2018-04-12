package wheretolunch.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import wheretolunch.model.Restaurant;
import wheretolunch.service.RestaurantService;
import wheretolunch.service.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


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

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/editMenu")
    public String edit(Model model, HttpServletRequest request) throws NotFoundException {
        model.addAttribute("users", restaurantService.get(Integer.parseInt(request.getParameter("id"))));
        return "editMenu";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @PutMapping(value = "/vote/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void vote(@PathVariable("id") int id) throws NotFoundException {
        userService.vote(id);
        Restaurant restaurant = restaurantService.get(id);
        restaurant.setVotes(restaurant.getVotes() + 1);
        restaurantService.update(restaurant);
    }

}


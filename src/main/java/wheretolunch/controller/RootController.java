package wheretolunch.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/userslist")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/editMenu")
    public String edit(Model model, HttpServletRequest request) throws NotFoundException {
        model.addAttribute("restaurant", restaurantService.get(Integer.parseInt(request.getParameter("id"))));
        return "editMenu";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }




}


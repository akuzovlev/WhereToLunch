package wheretolunch.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.support.GenericXmlApplicationContext;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import wheretolunch.service.RestaurantService;

        import javax.servlet.ServletConfig;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.validation.constraints.Null;
        import java.io.IOException;

@Controller
public class RootController extends HttpServlet {

    private GenericXmlApplicationContext springContext;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/")
    public String root(@RequestParam(name="restaurants", required=false, defaultValue="") String name, Model model) {
        model.addAttribute("restaurants", restaurantService.getAll());
        return "voting";
    }


}


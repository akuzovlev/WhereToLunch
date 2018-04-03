package wheretolunch.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.support.GenericXmlApplicationContext;
        import wheretolunch.service.DishService;

        import javax.servlet.ServletConfig;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

public class RootController extends HttpServlet {

    private GenericXmlApplicationContext springContext;
    private DishService dishService;

    @Autowired
    public RootController(DishService service) {
        this.dishService = service;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new GenericXmlApplicationContext();
        springContext.load("classpath:spring/*.xml");
        springContext.refresh();
        dishService = springContext.getBean(DishService.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("restaurants", dishService.getAllRestaurants());
        request.getRequestDispatcher("/voting.jsp").forward(request, response);
    }


}


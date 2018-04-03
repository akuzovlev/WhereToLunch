package wheretolunch.service;

import javassist.NotFoundException;
import wheretolunch.model.Dish;

import java.util.List;
import java.util.Map;

public interface DishService {

    Dish create(Dish user);

    void delete(int id) throws NotFoundException;

    Dish get(int id) throws NotFoundException;

    void update(Dish user);

    List<Dish> getAll();


    Map<String,List<Dish>> getAllRestaurants();

    List<Dish> getRestaurant();
}

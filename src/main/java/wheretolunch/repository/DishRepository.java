package wheretolunch.repository;

import wheretolunch.model.Dish;
import wheretolunch.model.Restaurant;

import java.util.List;


public interface DishRepository {

    Dish save(Dish dish);

    // null if not found
    Dish get(Integer id);

    // false if not found
    boolean delete(Integer id);

}

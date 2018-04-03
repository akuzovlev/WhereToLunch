package wheretolunch.repository;

import wheretolunch.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish save(Dish user);

    // false if not found
    boolean delete(Integer id);

    // null if not found
    Dish get(Integer id);

    List<Dish> getAll();


}

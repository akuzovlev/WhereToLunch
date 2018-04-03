package wheretolunch.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import wheretolunch.model.Dish;
import wheretolunch.model.User;

import java.util.List;
import java.util.Map;

@Service
public class DishServiceImpl implements DishService {

    @Override
    public Dish create(Dish user) {
        return null;
    }

    @Override
    public void delete(int id) throws NotFoundException {

    }

    @Override
    public Dish get(int id) throws NotFoundException {
        return null;
    }

    @Override
    public void update(Dish user) {

    }

    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    public Map<String, List<Dish>> getAllRestaurants() {
        return null;
    }

    @Override
    public List<Dish> getRestaurant() {
        return null;
    }
}

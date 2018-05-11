package wheretolunch.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import wheretolunch.model.Restaurant;
import wheretolunch.repository.RestaurantRepository;

import java.util.List;



@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) {
            throw new NotFoundException("Restaurant with id = " + id + " not found!");
        }
    }

    @Override
    public Restaurant get(int id) throws NotFoundException {
        Restaurant restaurant = repository.get(id);
        if (restaurant == null) {
            throw new NotFoundException("Restaurant with id = " + id + " not found!");
        }
        return restaurant;
    }

    @Override
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public Integer getVotesNumber(int id) {
        return repository.get(id).getVotedUsers().size();
    }
}

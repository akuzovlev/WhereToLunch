package wheretolunch.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import wheretolunch.Util.ExistsException;
import wheretolunch.model.Restaurant;
import wheretolunch.repository.HistoryRecordRepository;
import wheretolunch.repository.RestaurantRepository;

import java.util.List;


@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;
    private final HistoryRecordRepository historyRecordRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository, HistoryRecordRepository historyRecordRepository) {
        this.repository = repository;
        this.historyRecordRepository = historyRecordRepository;
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        if (repository.get(restaurant.getId()) != null) {
            throw new ExistsException("Restaurant with this id already exists");
        }
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
    public void update(Restaurant restaurant) throws NotFoundException {
        Assert.notNull(restaurant, "restaurant must not be null");
        if (repository.get(restaurant.getId()) == null) {
            throw new NotFoundException("Restaurant with id = " + restaurant.getId() + " not found!");
        }
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

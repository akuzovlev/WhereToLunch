package wheretolunch.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import wheretolunch.Util.ExistsException;
import wheretolunch.model.HistoryRecord;
import wheretolunch.model.Restaurant;
import wheretolunch.repository.HistoryRecordRepository;
import wheretolunch.repository.RestaurantRepository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        historyRecordRepository.save(new HistoryRecord(LocalDateTime.now().withNano(0), "Created: " + restaurant.toString(), "restaurant"));
        return repository.save(restaurant);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) {
            throw new NotFoundException("Restaurant with id = " + id + " not found!");
        }
        historyRecordRepository.save(new HistoryRecord(LocalDateTime.now().withNano(0), "Deleted: " + repository.get(id).toString(), "restaurant"));
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
    public Restaurant getWithoutVotes(int id) throws NotFoundException {
        Restaurant restaurant = repository.getWithoutVotes(id);
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
        historyRecordRepository.save(new HistoryRecord(LocalDateTime.now().withNano(0), "Updated: " + restaurant.toString(), "restaurant"));
        repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Restaurant> getAllWithoutVotes() {
        return repository.getAllWithoutVotes();
    }

    @Override
    public List<HistoryRecord> getRestaurantsHistory() {
        return historyRecordRepository.getRestaurantsHistory();
    }

}

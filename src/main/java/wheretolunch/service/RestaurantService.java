package wheretolunch.service;

import javassist.NotFoundException;
import org.springframework.security.access.annotation.Secured;
import wheretolunch.model.HistoryRecord;
import wheretolunch.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    @Secured({"ROLE_ADMIN"})
    Restaurant create(Restaurant restaurant);

    @Secured({"ROLE_ADMIN"})
    void delete(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    Restaurant get(int id) throws NotFoundException;

    Restaurant getWithoutVotes(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    void update(Restaurant restaurant) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    List<Restaurant> getAll();

    List<Restaurant> getAllWithoutVotes();

    @Secured({"ROLE_ADMIN"})
    List<HistoryRecord> getRestaurantsHistory();
}

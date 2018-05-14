package wheretolunch.repository;


import wheretolunch.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    // null if not found
    Restaurant get(Integer id);

    // false if not found
    boolean delete(Integer id);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithoutVotes();

    Restaurant getWithoutVotes(Integer id);
}

package wheretolunch.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wheretolunch.model.Restaurant;
import wheretolunch.model.RestaurantVotedNotIncluded;
import wheretolunch.model.RestaurantWithVotedUsers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.getId() == null) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    @Override
    public Restaurant get(Integer id) {
        return em.find(RestaurantWithVotedUsers.class, id);
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        return em.createNamedQuery(RestaurantWithVotedUsers.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

    @Override
    public List<Restaurant> getAll() {
        return em.createNamedQuery(RestaurantWithVotedUsers.ALL_SORTED, Restaurant.class).getResultList();
    }

    @Override
    public List<Restaurant> getAllWithoutVotes() {
        return em.createNamedQuery(RestaurantVotedNotIncluded.ALL_SORTED, Restaurant.class).getResultList();
    }

    @Override
    public Restaurant getWithoutVotes(Integer id) {
        return em.find(RestaurantVotedNotIncluded.class, id);
    }

}

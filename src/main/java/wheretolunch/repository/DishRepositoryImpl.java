package wheretolunch.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wheretolunch.model.Dish;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DishRepositoryImpl implements DishRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public Dish save(Dish dish) {
        if (dish.getId() == null) {
            em.persist(dish);
            return dish;
        } else {
            return em.merge(dish);
        }
    }

    @Override
    public Dish get(Integer id) {
        return em.find(Dish.class, id);
    }

    @Override
    public boolean delete(Integer id) {
        return em.createNamedQuery(Dish.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }

}

package wheretolunch.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wheretolunch.model.Dish;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DishRepositoryImpl implements DishRepository{

    @PersistenceContext
    private EntityManager em;


    public DishRepositoryImpl() {
    }

    @Override
    public Dish save(Dish user) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Dish get(Integer id) {
        return null;
    }

    @Override
    public List<Dish> getAll() {
        return null;
    }
}

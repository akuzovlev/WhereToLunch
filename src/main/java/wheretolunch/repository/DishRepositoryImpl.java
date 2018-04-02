package wheretolunch.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(readOnly = true)
public class DishRepositoryImpl implements DishRepository{

    @PersistenceContext
    private EntityManager em;




}

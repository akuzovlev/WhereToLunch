package wheretolunch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wheretolunch.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if (user.getId() == null) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public User get(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return em.createNamedQuery(User.ALL_SORTED, User.class).getResultList();
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        return em.createNamedQuery(User.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }


}

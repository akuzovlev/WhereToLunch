package wheretolunch.repository;

import wheretolunch.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);

    // false if not found
    boolean delete(Integer id);

    // null if not found
    User get(Integer id);

    List<User> getAll();

    User getByEmail(String email);
}

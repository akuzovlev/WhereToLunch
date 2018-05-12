package wheretolunch.service;

import javassist.NotFoundException;
import wheretolunch.model.User;

import java.util.List;

public interface UserService {

    User create(User user);

    void delete(int id) throws NotFoundException;

    User get(int id) throws NotFoundException;

    void update(User user) throws NotFoundException;

    List<User> getAll();

    boolean vote(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;
}

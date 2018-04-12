package wheretolunch.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import wheretolunch.model.User;
import wheretolunch.model.UserPrincipal;
import wheretolunch.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

import static wheretolunch.model.Role.ROLE_ADMIN;
import static wheretolunch.model.Role.ROLE_USER;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return repository.save(user);
    }


    @Override
    public void delete(int id) throws NotFoundException {
       repository.delete(id);
    }

    @Override
    public User get(int id) throws NotFoundException {
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        repository.save(user);
    }

    @Override
    public void vote(int userId, int id) throws NotFoundException {
      /*  User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();*/
        User currentUser = repository.get(userId);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        Assert.notNull(email, "email must not be null");
        return repository.getByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getByEmail(username.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " is not found");
        }

        return new UserPrincipal(user);
    }
}

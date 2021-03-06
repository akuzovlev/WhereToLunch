package wheretolunch.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import wheretolunch.Util.ExistsException;
import wheretolunch.model.HistoryRecord;
import wheretolunch.model.User;
import wheretolunch.model.UserPrincipal;
import wheretolunch.repository.HistoryRecordRepository;
import wheretolunch.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;
    private final HistoryRecordRepository historyRecordRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository, HistoryRecordRepository historyRecordRepository) {
        this.repository = repository;
        this.historyRecordRepository = historyRecordRepository;
    }


    @Override
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        if ((user.getId() != null && repository.get(user.getId()) != null) || repository.getByEmail(user.getEmail()) != null) {
            throw new ExistsException("User with this id already exists");
        }
        return repository.save(user);
    }


    @Override
    public void delete(int id) throws NotFoundException {
        if (!repository.delete(id)) {
            throw new NotFoundException("User with id = " + id + " not found!");
        }
    }

    @Override
    public User get(int id) throws NotFoundException {
        User user = repository.get(id);
        if (user == null) {
            throw new NotFoundException("User with id = " + id + " not found!");
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void update(User user) throws NotFoundException {
        Assert.notNull(user, "user must not be null");
        if (repository.get(user.getId()) == null) {
            throw new NotFoundException("Restaurant with id = " + user.getId() + " not found!");
        }
        repository.save(user);
    }

    @Override
    public boolean vote(int id) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = repository.get(userPrincipal.getUser().getId());
        LocalDateTime eleven = LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0));
        if (user.getVotedRestaurantId() == null || LocalDateTime.now().isBefore(eleven)) {
            user.setVotedRestaurantId(id);
            repository.save(user);
            historyRecordRepository.save(new HistoryRecord(LocalDateTime.now().withNano(0), "Vote: " + user.toString(), "user"));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<HistoryRecord> getVotesHistory() {
        return historyRecordRepository.getUserVotesHistory();
    }


    @Override
    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return repository.getByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new UserPrincipal(user);
    }
}

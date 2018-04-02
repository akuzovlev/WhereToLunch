package wheretolunch.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import wheretolunch.model.User;

public class UserServiceImplTest {

    @Autowired
    protected UserService service;

    @Test
    public void create() throws Exception {
        User newUser = new User("new@gmail.com", "newName","newPass");
        User created = service.create(newUser);
        newUser.setId(created.getId());
    }

    @org.junit.Test
    public void delete() {
    }

    @org.junit.Test
    public void get() {
    }

    @org.junit.Test
    public void getAll() {
    }

    @org.junit.Test
    public void update() {
    }
}

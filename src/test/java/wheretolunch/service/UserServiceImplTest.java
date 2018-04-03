package wheretolunch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wheretolunch.model.User;

import javax.swing.*;


@ContextConfiguration({"classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
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

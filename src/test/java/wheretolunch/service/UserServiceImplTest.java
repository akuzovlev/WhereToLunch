package wheretolunch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wheretolunch.model.User;
import static org.assertj.core.api.Assertions.assertThat;

import static wheretolunch.UserTestData.USER;
import static wheretolunch.UserTestData.USER_ID;


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

    @Test
    public void delete() {
    }

    @Test
    public void get() throws Exception{
        User user = service.get(USER_ID);
        assertThat(user).isEqualToIgnoringGivenFields(USER);
    }

    @Test
    public void getAll() {
    }

    @Test
    public void update() {
    }
}

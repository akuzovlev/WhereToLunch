package wheretolunch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wheretolunch.model.Restaurant;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static wheretolunch.RestaurantTestData.RESTAURANT1;
import static wheretolunch.RestaurantTestData.RESTAURANT1_ID;


@ContextConfiguration({"classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RestaurantServiceImplTest {

    @Autowired
    protected RestaurantService service;

    @Test
    public void create() {
    }

    @Test
    public void delete() throws Exception {
        service.delete(RESTAURANT1_ID);
        List<Restaurant> all = service.getAll();

    }

    @Test
    public void get() throws Exception {
        Restaurant restaurant = service.get(RESTAURANT1_ID);
        assertThat(restaurant).isEqualTo(RESTAURANT1);
    }

    @Test
    public void update() {
        Restaurant r = RESTAURANT1;
        r.setName("gggggggg");
        service.update(r);
    }

    @Test
    public void getAll() {
        List<Restaurant> all = service.getAll();
    }
}
package wheretolunch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wheretolunch.model.Restaurant;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static wheretolunch.RestaurantTestData.RESTAURANT;
import static wheretolunch.RestaurantTestData.RESTAURANT_ID;


@ContextConfiguration({"classpath:spring/spring-mvc.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RestaurantServiceImplTest {

    @Autowired
    protected RestaurantService service;

    @Test
    public void create() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() throws Exception {
        Restaurant restaurant = service.get(RESTAURANT_ID);
        assertThat(restaurant).isEqualToIgnoringGivenFields(RESTAURANT);
    }

    @Test
    public void update() {
    }

    @Test
    public void getAll() {
        List<Restaurant> all = service.getAll();
all.add(RESTAURANT);
    }
}
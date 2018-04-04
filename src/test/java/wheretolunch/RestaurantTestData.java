package wheretolunch;

import wheretolunch.model.Dish;
import wheretolunch.model.Restaurant;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static wheretolunch.model.BaseEntity.START_SEQ;

public class RestaurantTestData {

    public static final int RESTAURANT_ID = START_SEQ + 2;

    public static final List<Dish> DISHES1 = Arrays.asList(
            new Dish("Fresh melon fruit salad", 2.30, RESTAURANT_ID),
            new Dish("Zucchini light soup", 5.14, RESTAURANT_ID),
            new Dish("Asparagus frittata", 7.14, RESTAURANT_ID),
            new Dish("Baked apple", 1.04, RESTAURANT_ID),
            new Dish("Green tea", 0.60, RESTAURANT_ID)
            );

    public static final Restaurant RESTAURANT = new Restaurant(RESTAURANT_ID, "Cafe Pushkin", DISHES1);
}

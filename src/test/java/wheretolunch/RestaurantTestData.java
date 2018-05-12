package wheretolunch;

import wheretolunch.model.Dish;
import wheretolunch.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import static wheretolunch.model.BaseEntity.START_SEQ;

public class RestaurantTestData {

    public static final int RESTAURANT1_ID = START_SEQ + 2;

    public static final List<Dish> DISHES1 = Arrays.asList(
            new Dish("Fresh melon fruit salad", 230, RESTAURANT1_ID),
            new Dish("Zucchini light soup", 514, RESTAURANT1_ID),
            new Dish("Asparagus frittata", 714, RESTAURANT1_ID),
            new Dish("Baked apple", 104, RESTAURANT1_ID),
            new Dish("Green tea", 060, RESTAURANT1_ID)
            );

    public static final Restaurant RESTAURANT1 = new Restaurant(RESTAURANT1_ID, "Cafe Pushkin", DISHES1);
}

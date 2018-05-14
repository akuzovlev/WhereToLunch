package wheretolunch.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@MappedSuperclass
public class Restaurant extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurantId")
    protected List<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<Dish> dishes) {
        super(id);
        this.name = name;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}

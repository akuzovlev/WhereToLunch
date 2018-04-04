package wheretolunch.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.ALL_SORTED, query = "SELECT r FROM Restaurant r ORDER BY r.name")
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity {

    public static final String DELETE = "Restaurant.delete";
    public static final String ALL_SORTED = "Restaurant.getAllSorted";

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    private String name;

    @Column(name = "votes", nullable = false)
    @NotBlank
    private Integer votes;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="restaurantId")
    protected List<Dish> dishes;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<Dish> dishes) {
        super(id);
        this.name = name;
        this.dishes = dishes;
        this.votes = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}

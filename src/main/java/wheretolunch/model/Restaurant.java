package wheretolunch.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.ALL_SORTED, query = "SELECT r FROM Restaurant r ORDER BY r.name DESC")
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends BaseEntity {

    public static final String DELETE = "Restaurant.delete";
    public static final String ALL_SORTED = "Restaurant.getAllSorted";

    @Column(name = "name", nullable = false, unique = true)
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="restaurantId")
    protected List<Dish> dishes;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy="votedRestaurantId")
    protected Set<User> votedUsers;

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

    public Set<User> getVotedUsers() {
        return votedUsers;
    }

    public void setVotedUsers(Set<User> votedUsers) {
        this.votedUsers = votedUsers;
    }
}

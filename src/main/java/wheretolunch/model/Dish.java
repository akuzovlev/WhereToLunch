package wheretolunch.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id")
})
@Entity
@Table(name = "dishes")
public class Dish extends BaseEntity {

    public static final String DELETE = "Dish.delete";

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "price", nullable = false)
    @NotNull
    private Integer price;

    @Column(name = "restaurant_id", nullable = false)
    @NotNull
    private Integer restaurantId;


    public Dish() {
    }

    public Dish(String description, Integer price, Integer restaurantId) {
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}

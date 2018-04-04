package wheretolunch.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @NotBlank
    private double price;

    @Column(name = "restaurant_id", nullable = false)
    @NotBlank
    private Integer restaurantId;


    public Dish() {
    }

    public Dish(String description, double price, Integer restaurantId) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

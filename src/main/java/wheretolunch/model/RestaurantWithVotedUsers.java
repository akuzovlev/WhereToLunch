package wheretolunch.model;

import javax.persistence.*;
import java.util.Set;


@NamedQueries({
        @NamedQuery(name = RestaurantWithVotedUsers.DELETE, query = "DELETE FROM RestaurantWithVotedUsers r WHERE r.id=:id"),
        @NamedQuery(name = RestaurantWithVotedUsers.ALL_SORTED, query = "SELECT r FROM RestaurantWithVotedUsers r ORDER BY r.name DESC")
})

@Entity
@Table(name = "restaurants")
public class RestaurantWithVotedUsers extends Restaurant {

    public static final String DELETE = "RestaurantWithVotedUsers.delete";
    public static final String ALL_SORTED = "RestaurantWithVotedUsers.getAllSorted";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "votedRestaurantId")
    protected Set<User> votedUsers;

    public Set<User> getVotedUsers() {
        return votedUsers;
    }

    public void setVotedUsers(Set<User> votedUsers) {
        this.votedUsers = votedUsers;
    }

}

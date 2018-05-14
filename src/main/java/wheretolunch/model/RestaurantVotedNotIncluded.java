package wheretolunch.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries({
        @NamedQuery(name = RestaurantVotedNotIncluded.ALL_SORTED, query = "SELECT r FROM RestaurantVotedNotIncluded r ORDER BY r.name DESC")
})

@Entity
@Table(name = "restaurants")
public class RestaurantVotedNotIncluded extends Restaurant {
    public static final String ALL_SORTED = "RestaurantVotedNotIncluded.getAllSorted";
}

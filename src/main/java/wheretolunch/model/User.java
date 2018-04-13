package wheretolunch.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.name"),
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT DISTINCT u FROM User u WHERE u.email=?1")
})
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";
    public static final String BY_EMAIL = "User.getByEmail";

    @Column(name = "admin")
    private boolean admin;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Column(name = "votetime")
    private LocalDateTime voteTime;

    @Column(name = "voterestaurantid")
    private Integer voteRestaurantId;

    public User() {
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.admin = false;
    }

    public User(Integer id, String email, String name, String password) {
        super(id);
        this.admin = false;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(LocalDateTime voteTime) {
        this.voteTime = voteTime;
    }

    public Integer getVoteRestaurantId() {
        return voteRestaurantId;
    }

    public void setVoteRestaurantId(Integer voteRestaurantId) {
        this.voteRestaurantId = voteRestaurantId;
    }
}

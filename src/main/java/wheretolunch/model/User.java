package wheretolunch.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private boolean admin;
    private String email;
    private String name;
    private String password;
    private LocalDateTime voteTime;


}

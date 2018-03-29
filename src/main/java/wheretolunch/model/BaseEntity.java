package wheretolunch.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
}

package social.petting.pettingpersonservice.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Role implements Serializable {
    @Serial
    private static final long serialVersionUID = -734532191793775205L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(500)", length = 500, nullable = false)
    private String description;

    @Column(columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
    private String status;


    @ManyToMany(targetEntity = Person.class, mappedBy = "roleSet")
    private Set<Person> personSet;
}

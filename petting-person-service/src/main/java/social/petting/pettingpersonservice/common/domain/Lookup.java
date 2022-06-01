package social.petting.pettingpersonservice.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.barker.pbpersonservice.user.domain.Person;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Lookup implements Serializable {
    @Serial
    private static final long serialVersionUID = -1254705070331299850L;
    @Id
    private long id;

    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;

    @Column(columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(100)", length = 100, nullable = false, unique = true)
    private String value;

    @Column(columnDefinition = "VARCHAR(500)", length = 500, nullable = false)
    private String description;

    @Column(columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
    private String typeTitle;

    private long typeId;

    @Column(columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
    private String status;


    private Long parentId;

    private int sortOrder;

    @OneToMany(mappedBy = "locationId", targetEntity = Person.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Person> person;
}

package social.petting.pettingpersonservice.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.barker.pbpersonservice.common.domain.Lookup;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = -4055796970549769065L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String userId;

    @Column(nullable = false, unique = true, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String username;

    @Column(nullable = false, unique = true, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(nullable = false, unique = true, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String phone;

    @Column(nullable = false, unique = true, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String nickName;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime modifiedOn;

    @Column(nullable = false)
    private LocalDateTime lastLoginOn;

    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private boolean suspended;

    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private boolean verified;

    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private boolean deactivated;

    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private boolean locked;
    ;

    @Column(nullable = false, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String salt;

    @Column(nullable = false, length = 500, updatable = false, columnDefinition = "VARCHAR(500)")
    private String password;

    @Column(nullable = false, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String avatar;

    @Column(nullable = false, length = 1000, updatable = false, columnDefinition = "VARCHAR(1000)")
    private String bio;

    @Column(nullable = false, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String website;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    private Lookup locationId;

    @ManyToMany
    @JoinTable(
            name = "role_Id",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id"))
    private Set<Role> roleSet;


}

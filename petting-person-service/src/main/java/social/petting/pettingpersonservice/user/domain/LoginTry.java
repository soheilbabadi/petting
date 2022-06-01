package social.petting.pettingpersonservice.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class LoginTry implements java.io.Serializable {


    @Serial
    private static final long serialVersionUID = -7877770627998726165L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String username;

    @Column(nullable = false, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String ip;

    @Column(nullable = false, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String userAgent;

    private LocalDateTime loginOn;

    @Column(nullable = false, length = 100, updatable = false, columnDefinition = "VARCHAR(100)")
    private String loginResult;


    private boolean loginSuccess;


    private String device;
    private String os;
    private String browser;

}

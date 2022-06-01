package social.petting.pettingpersonservice.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class VerifyCode implements Serializable {
    @Serial
    private static final long serialVersionUID = -6085220722301507034L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, columnDefinition = "VARCHAR(6)", length = 6)
    private String code;
    private LocalDateTime createOn;
    private LocalDateTime expireOn;
    private String phone;
    @Column(nullable = false, columnDefinition = "VARCHAR(10)", length = 10)
    private String type;
    @Column(nullable = false, columnDefinition = "VARCHAR(100)", length = 100)
    private String email;

}

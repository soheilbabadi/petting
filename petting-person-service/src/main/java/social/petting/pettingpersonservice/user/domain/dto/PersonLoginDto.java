package social.petting.pettingpersonservice.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonLoginDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 777167635484396210L;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;

    private String ip;
    private String userAgent;
    private String device;
    private String os;
    private String browser;
}

}

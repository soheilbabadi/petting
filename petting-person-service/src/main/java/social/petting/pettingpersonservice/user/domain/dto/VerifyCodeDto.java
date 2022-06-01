package social.petting.pettingpersonservice.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class VerifyCodeDto implements java.io.Serializable {
    private static final long serialVersionUID = -87901990065881607L;
    private String code;
    private String email;
    private String phone;
}



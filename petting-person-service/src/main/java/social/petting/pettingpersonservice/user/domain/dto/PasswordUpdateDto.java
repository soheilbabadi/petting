package social.petting.pettingpersonservice.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PasswordUpdateDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -3730269669223115978L;
    private String oldPassword;
    private String newPassword;
    private String username;

}

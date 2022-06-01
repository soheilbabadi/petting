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
public class PersonUpdateDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 551150461591839856L;


    private String userId;

    private String username;

    private String email;

    private String phone;

    private String nickName;

    private String avatar;

    private String bio;

    private String website;

    private long locationId;

}

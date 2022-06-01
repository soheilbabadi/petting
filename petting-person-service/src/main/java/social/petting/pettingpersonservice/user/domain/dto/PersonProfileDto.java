package social.petting.pettingpersonservice.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import social.petting.pettingpersonservice.common.domain.Lookup;

import java.io.Serial;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonProfileDto implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 2484680794746942745L;

    private long id;

    private String userId;

    private String username;

    private String email;

    private String phone;

    private String nickName;

    private LocalDateTime createdOn;

    private LocalDateTime modifiedOn;

    private LocalDateTime lastLoginOn;

    private boolean suspended;

    private boolean verified;

    private boolean deactivated;

    private boolean locked;

    private String avatar;

    private String bio;

    private String website;

    private Lookup locationId;
}

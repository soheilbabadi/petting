package social.petting.pettingpersonservice.user.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AvatarUpdateDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 5034828332995219941L;

    private MultipartFile avatar;
    private String username;

}

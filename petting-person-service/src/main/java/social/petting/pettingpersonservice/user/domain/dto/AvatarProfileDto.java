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
public class AvatarProfileDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -7923635432577845614L;

    private long originalFileSize;

    private String originalFileMimeType;

    private byte[] originalFile;

}

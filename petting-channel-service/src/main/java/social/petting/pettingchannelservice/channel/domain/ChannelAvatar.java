package social.petting.pettingchannelservice.channel.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChannelAvatar implements Serializable {

    @Serial
    private static final long serialVersionUID = -8765094791562679089L;
    @Id
    @Column(nullable = false, columnDefinition = "varchar(32)", length = 32)
    private String id;
    private String avatarUri;

}

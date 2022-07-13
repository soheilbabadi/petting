package social.petting.pettingchannelservice.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MemberDto implements Serializable {


    @Serial
    private static final long serialVersionUID = -2283832929683050507L;

    private String username;
    private String firstName;
    private String lastName;
    private String avatarUri;

    public List<Channel> channels;
}

package social.petting.pettingchannelservice.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChannelDto implements Serializable {


    @Serial
    private static final long serialVersionUID = 1493997620557021797L;
    private long id;
    @NotBlank(message = "Channel name is required")
    private String channelName;
    private String channelDescription;
    private String channelOwner;

    private String channelType;

    private String channelStatus;

    @Past(message = "Created on date must be in the past")
    private LocalDateTime channelCreatedOn;




}

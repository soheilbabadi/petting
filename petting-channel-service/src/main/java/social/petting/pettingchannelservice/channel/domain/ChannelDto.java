package social.petting.pettingchannelservice.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChannelDto implements Serializable {


    private long id;
    private String channelName;
    private String channelDescription;
    private String channelOwner;
    private String channelType;
    private String channelStatus;

    private LocalDateTime channelCreatedOn;
    private LocalDateTime channelUpdatedOn;
    private LocalDateTime channelDeletedOn;


}

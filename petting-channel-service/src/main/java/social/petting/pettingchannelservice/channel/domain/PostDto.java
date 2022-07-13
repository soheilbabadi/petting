package social.petting.pettingchannelservice.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PostDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -1393004843828180207L;
    @NotEmpty(message = "Channel is required")
    public long channelId;
    private long id;
    @NotBlank(message = "Post body is required")
    private String postBody;
    @NotEmpty(message = "Post owner is required")
    private String postOwner;
    private String ownerAvatarUri;
    private LocalDateTime updatedOn;
    private LocalDateTime createdOn;
    private boolean edited;
}

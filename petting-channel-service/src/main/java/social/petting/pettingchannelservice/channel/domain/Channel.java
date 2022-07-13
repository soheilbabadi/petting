package social.petting.pettingchannelservice.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true, length = 100)
    private String channelName;
    @Column(nullable = false, unique = true, length = 1000)
    private String channelDescription;
    private String channelOwner;
    private String channelType;
    private String channelStatus;

    private LocalDateTime ceatedOn;
    private LocalDateTime updatedOn;
    private LocalDateTime deletedOn;


}

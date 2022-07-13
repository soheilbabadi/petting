package social.petting.pettingchannelservice.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Channel implements Serializable {

    @Serial
    private static final long serialVersionUID = -1733980227130679610L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true, length = 100)
    private String channelName;
    @Column(nullable = false, unique = true, length = 500, columnDefinition = "varchar(500)")
    private String channelDescription;

    private String channelType;
    private String channelStatus;
    private String avatarUri;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;


    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, targetEntity = Member.class)
    private Member channelOwner;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Member.class)
    public List<Member> members;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "channel", cascade = CascadeType.ALL, targetEntity = Post.class)
    public List<Post> posts;


}

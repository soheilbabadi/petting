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
    @Column(nullable = false, unique = true, length = 500,columnDefinition = "varchar(500)")
    private String channelDescription;
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, targetEntity = Member.class)
    private Member channelOwner;


    private String channelType;
    private String channelStatus;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "channel", cascade = CascadeType.ALL, targetEntity = Post.class)
    public List<Post> posts;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "channels", cascade = CascadeType.ALL, targetEntity = Member.class)
    @JoinTable(name = "channel_member", joinColumns = @JoinColumn(name = "channel_id"), inverseJoinColumns = @JoinColumn(name = "member_id"))
    public List<Member> members;
}

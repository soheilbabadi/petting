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
@Entity
public class Member implements Serializable {


    @Serial
    private static final long serialVersionUID = -1461729640517599650L;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "members", cascade = CascadeType.ALL, targetEntity = Channel.class)
    public List<Channel> channels;
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, targetEntity = Post.class)
    public Post post;
    @Id
    @Column(nullable = false, columnDefinition = "varchar(32)", length = 32)
    private String username;
    @Column(nullable = false, columnDefinition = "varchar(100)", length = 100)
    private String firstName;
    @Column(nullable = false, columnDefinition = "varchar(100)", length = 100)
    private String lastName;
    @Column(nullable = false, columnDefinition = "varchar(300)", length = 300)
    private String avatarUri;
}

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


    @Id
    private String username;
    @Column(nullable = false, columnDefinition = "varchar(100)", length = 100)
    private String firstName;
    @Column(nullable = false, columnDefinition = "varchar(100)", length = 100)
    private String lastName;
    @Column(nullable = false, columnDefinition = "varchar(300)", length = 300)
    private String avatarUri;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "members", cascade = CascadeType.ALL, targetEntity = Channel.class)
    public List<Channel> channels;
}

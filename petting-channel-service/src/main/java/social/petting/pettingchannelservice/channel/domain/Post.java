package social.petting.pettingchannelservice.channel.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 9066621312570212031L;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, targetEntity = Channel.class)
    public Channel channel;
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL, targetEntity = Member.class)
    public Member postOwner;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, columnDefinition = "text", length = 10000)
    private String postBody;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private boolean edited;

}

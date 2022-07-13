package social.petting.pettingchannelservice.channel.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import social.petting.pettingchannelservice.channel.domain.Channel;
import social.petting.pettingchannelservice.channel.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByPostOwner(String postOwner);
    List<Post> findByPostType(String postType);
    List<Post> findByChannel(Channel channel);
    List<Post> findByPostOwnerAndChannel(String postOwner,Channel channel);
}

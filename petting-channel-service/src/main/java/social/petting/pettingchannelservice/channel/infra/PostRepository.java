package social.petting.pettingchannelservice.channel.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import social.petting.pettingchannelservice.channel.domain.Channel;
import social.petting.pettingchannelservice.channel.domain.Member;
import social.petting.pettingchannelservice.channel.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    Iterable<Post> findByPostOwner(Member postOwner);

    Iterable<Post> findByChannel(Channel channel);

    Iterable<Post> findByPostOwnerAndChannel(String postOwner, Channel channel);
}

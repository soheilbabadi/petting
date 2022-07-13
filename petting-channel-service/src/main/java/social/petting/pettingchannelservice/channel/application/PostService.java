package social.petting.pettingchannelservice.channel.application;

import org.springframework.transaction.annotation.Transactional;
import social.petting.pettingchannelservice.channel.domain.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByPostOwner(String postOwner);


    @Transactional
    long createPost(PostDto postDto);

    long updatePost(PostDto postDto);

    long deletePost(long id);
}

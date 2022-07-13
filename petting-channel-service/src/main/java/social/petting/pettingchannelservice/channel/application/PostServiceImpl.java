package social.petting.pettingchannelservice.channel.application;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import social.petting.pettingchannelservice.channel.domain.Post;
import social.petting.pettingchannelservice.channel.domain.PostDto;
import social.petting.pettingchannelservice.channel.infra.ChannelRepository;
import social.petting.pettingchannelservice.channel.infra.PostRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
@Transactional(isolation = Isolation.SERIALIZABLE)
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ChannelRepository channelRepository;


    @Override
    public List<PostDto> findByPostOwner(String postOwner) {
        var modelList = postRepository.findByPostOwner(postOwner);
        var dtoList = new ArrayList<PostDto>();

        for (var post : modelList) {
            var item = new PostDto();
            BeanUtils.copyProperties(post, item);
            dtoList.add(item);
        }
        return dtoList;
    }




    @Override
    @Transactional
    public long createPost(PostDto postDto) {
        var post = copyProperty(postDto);
        post.setCreatedOn(LocalDateTime.now(ZoneOffset.UTC));
        post.setUpdatedOn(LocalDateTime.now(ZoneOffset.UTC));
        postRepository.save(post);

        //set chanel update
        var channel = channelRepository.findById(postDto.getChannelId())
                .orElseThrow(() -> new RuntimeException("Channel not found"));
        channel.setUpdatedOn(LocalDateTime.now(ZoneOffset.UTC));
        channelRepository.save(channel);


        return post.getId();
    }

    @Override
    public long updatePost(PostDto postDto) {
        var post = postRepository.findById(postDto.getId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        post.setPostOwner(postDto.getPostOwner());
        post.setPostBody(postDto.getPostBody());
        post.setEdited(true);
        post.setUpdatedOn(LocalDateTime.now(ZoneOffset.UTC));
        postRepository.save(post);
        return post.getId();
    }

    @Override
    public long deletePost(long id) {
        postRepository.deleteById(id);
        return 1;
    }

    private Post copyProperty(PostDto postDto) {
        var channel = channelRepository.findById(postDto.getChannelId())
                .orElseThrow(() -> new RuntimeException("Channel not found"));

        return Post.builder()
                .id(postDto.getId())
                .postBody(postDto.getPostBody())
                .postOwner(postDto.getPostOwner())
                .channel(channel)
                .createdOn(postDto.getCreatedOn())
                .edited(postDto.isEdited())
                .build();


    }

    private PostDto copyProperty(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .postBody(post.getPostBody())
                .postOwner(post.getPostOwner())
                .channelId(post.getChannel().getId())
                .createdOn(post.getCreatedOn())
                .edited(post.isEdited())
                .build();
    }

}

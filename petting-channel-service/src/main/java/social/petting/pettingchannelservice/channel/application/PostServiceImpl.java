package social.petting.pettingchannelservice.channel.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import social.petting.pettingchannelservice.channel.domain.Post;
import social.petting.pettingchannelservice.channel.domain.PostDto;
import social.petting.pettingchannelservice.channel.infra.ChannelRepository;
import social.petting.pettingchannelservice.channel.infra.MemberRepositry;
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

    @Autowired
    private MemberRepositry memberRepositry;


    @Override
    public List<PostDto> findByPostOwner(String postOwner) {
        var owner = memberRepositry.findByUsername(postOwner);
        var modelList = postRepository.findByPostOwner(owner);
        var dtoList = new ArrayList<PostDto>();

        for (var post : modelList) {

            var item = PostDto.builder()
                    .id(post.getId())
                    .postOwner(post.postOwner.getFirstName() + " " + post.postOwner.getLastName())
                    .postBody(post.getPostBody())
                    .createdOn(post.getCreatedOn())
                    .channelId(post.getChannel().getId())
                    .edited(post.isEdited())
                    .ownerAvatarUri(post.postOwner.getAvatarUri())
                    .build();


            dtoList.add(item);
        }
        return dtoList;
    }


    @Override
    @Transactional
    public long createPost(PostDto postDto) {
        var post = copyProperty(postDto);
        var owner = memberRepositry.findByUsername(postDto.getPostOwner());
        post.setCreatedOn(LocalDateTime.now(ZoneOffset.UTC));
        post.setUpdatedOn(LocalDateTime.now(ZoneOffset.UTC));
        post.setPostOwner(owner);
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
        var owner = memberRepositry.findByUsername(postDto.getPostOwner());
        return Post.builder()
                .id(postDto.getId())
                .postBody(postDto.getPostBody())
                .postOwner(owner)
                .channel(channel)
                .createdOn(postDto.getCreatedOn())
                .edited(postDto.isEdited())
                .build();

    }

    private PostDto copyProperty(Post post) {
        return PostDto.builder()
                .id(post.getId())
                .postBody(post.getPostBody())
                .postOwner(post.getPostOwner().getFirstName() + " " + post.getPostOwner().getLastName())
                .channelId(post.getChannel().getId())
                .createdOn(post.getCreatedOn())
                .edited(post.isEdited())
                .build();
    }

}

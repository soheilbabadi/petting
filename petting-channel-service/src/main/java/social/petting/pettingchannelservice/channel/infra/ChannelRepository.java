package social.petting.pettingchannelservice.channel.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social.petting.pettingchannelservice.channel.domain.Channel;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    List<Channel> findByChannelNameContainingOrderByChannelUpdatedOnDesc(String channelName);

    List<Channel> findByChannelStatusOrderByChannelUpdatedOnDesc(String channelStatus);

    List<Channel> findByChannelOwnerOrderByChannelUpdatedOnDesc(String channelOwner);

    List<Channel> findByChannelTypeOrderByChannelUpdatedOnDesc(String channelOwner);

}

package social.petting.pettingchannelservice.channel.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import social.petting.pettingchannelservice.channel.domain.Channel;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Iterable<Channel> findByChannelNameContaining(String channelName);

    Iterable<Channel> findByChannelStatus(String channelStatus);

    Iterable<Channel> findByChannelOwner(String channelOwner);

    Iterable<Channel> findByChannelType(String channelOwner);

}

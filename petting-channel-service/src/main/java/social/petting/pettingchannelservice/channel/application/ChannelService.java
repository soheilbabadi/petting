package social.petting.pettingchannelservice.channel.application;

import social.petting.pettingchannelservice.channel.domain.ChannelDto;

import java.util.List;

public interface ChannelService {
    List<ChannelDto> findByChannelNameContaining(String channelName);

    long createChannel(ChannelDto channelDto);

    long updateChannel(ChannelDto channelDto);

    long deleteChannel(long id);

    ChannelDto findById(long id);

    List<ChannelDto> findAll();

    List<ChannelDto> findByChannelOwner(String channelOwner);

    List<ChannelDto> findByChannelType(String channelType);

    List<ChannelDto> findByChannelStatus(String channelStatus);
}

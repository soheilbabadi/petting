package social.petting.pettingchannelservice.channel.application;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import social.petting.pettingchannelservice.channel.domain.Channel;
import social.petting.pettingchannelservice.channel.domain.ChannelDto;
import social.petting.pettingchannelservice.channel.infra.ChannelRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    @Override
    public List<ChannelDto> findByChannelNameContaining(String channelName) {
        var modelList = channelRepository.findByChannelNameContainingOrderByChannelUpdatedOnDesc(channelName);
        var dtoList = new ArrayList<ChannelDto>();

        for (var channel : modelList) {
            var item = new ChannelDto();
            BeanUtils.copyProperties(channel, item);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public long createChannel(ChannelDto channelDto) {
        var channel = new Channel();
        BeanUtils.copyProperties(channelDto, channel);
        channel.setCeatedOn(LocalDateTime.now());
        channel.setUpdatedOn(LocalDateTime.now());
        channel.setDeletedOn(null);
        channelRepository.save(channel);
        return channel.getId();
    }

    @Override
    public long updateChannel(ChannelDto channelDto) {
        var channel = channelRepository.findById(channelDto.getId())
                .orElseThrow(() -> new RuntimeException("Channel not found"));
        BeanUtils.copyProperties(channelDto, channel);
        channel.setUpdatedOn(LocalDateTime.now());
        channelRepository.save(channel);
        return channel.getId();
    }

    @Override
    public long deleteChannel(long id) {
        var channel = channelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Channel not found"));
        channel.setDeletedOn(LocalDateTime.now());
        channelRepository.save(channel);
        return channel.getId();
    }

    @Override
    public ChannelDto findById(long id) {
        var channel = channelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Channel not found"));
        var item = new ChannelDto();
        BeanUtils.copyProperties(channel, item);
        return item;
    }

    @Override
    public List<ChannelDto> findAll() {
        var modelList = channelRepository.findAll();
        var dtoList = new ArrayList<ChannelDto>();

        for (var channel : modelList) {
            var item = new ChannelDto();
            BeanUtils.copyProperties(channel, item);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public List<ChannelDto> findByChannelOwner(String channelOwner) {
        var modelList = channelRepository.findByChannelOwnerOrderByChannelUpdatedOnDesc(channelOwner);
        var dtoList = new ArrayList<ChannelDto>();

        for (var channel : modelList) {
            var item = new ChannelDto();
            BeanUtils.copyProperties(channel, item);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public List<ChannelDto> findByChannelType(String channelType) {
        var modelList = channelRepository.findByChannelTypeOrderByChannelUpdatedOnDesc(channelType);
        var dtoList = new ArrayList<ChannelDto>();

        for (var channel : modelList) {
            var item = new ChannelDto();
            BeanUtils.copyProperties(channel, item);
            dtoList.add(item);
        }
        return dtoList;
    }

    @Override
    public List<ChannelDto> findByChannelStatus(String channelStatus) {
        var modelList = channelRepository.findByChannelStatusOrderByChannelUpdatedOnDesc(channelStatus);
        var dtoList = new ArrayList<ChannelDto>();

        for (var channel : modelList) {
            var item = new ChannelDto();
            BeanUtils.copyProperties(channel, item);
            dtoList.add(item);
        }
        return dtoList;
    }

}

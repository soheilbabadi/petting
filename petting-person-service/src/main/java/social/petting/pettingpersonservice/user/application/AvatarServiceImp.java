package social.petting.pettingpersonservice.user.application;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import social.petting.pettingpersonservice.common.application.Utils;
import social.petting.pettingpersonservice.user.domain.Avatar;
import social.petting.pettingpersonservice.user.domain.dto.AvatarProfileDto;
import social.petting.pettingpersonservice.user.domain.dto.AvatarUpdateDto;
import social.petting.pettingpersonservice.user.infra.AvatarRepository;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Service
public class AvatarServiceImp implements AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    @Override
    public String setAvatar(AvatarUpdateDto dto) throws IOException {
        if (dto.getUsername() == null) {   // username is required
            throw new IllegalArgumentException("username is required");
        }

        if (dto.getAvatar() == null) {   // avatar is required
            throw new IllegalArgumentException("avatar is required");
        }

        if (dto.getAvatar().getSize() > Utils.MAX_FILE_SIZE) {
            // avatar   size is too large
            throw new IllegalArgumentException("avatar size is too large");
        }

        if (!Objects.equals(dto.getAvatar().getContentType(), "image/jpeg")) {
            throw new IllegalArgumentException("avatar is not a jpeg");
        }

        //remove existing avatar
        deleteFile(dto.getUsername());


        var avatar = new Avatar();
        avatar.setUsername(dto.getUsername());
        avatar.setId(UUID.randomUUID().toString());
        avatar.setCreatedOn(Utils.getUtc());

        avatar.setOriginalFile(dto.getAvatar().getBytes());
        avatar.setModifiedOn(Utils.getUtc());
        avatar.setCreatedOn(Utils.getUtc());
        avatar.setImageUrl(Utils.getBaseUrl() + "/api/v1/avatar/" + dto.getUsername());
        avatar.setOriginalFileExtension(Objects.requireNonNull(dto.getAvatar().getOriginalFilename()).split("\\.")[1]);
        avatar.setOriginalFileMimeType(dto.getAvatar().getContentType());
        avatar.setOriginalFileSize(dto.getAvatar().getSize());


        return avatarRepository.save(avatar).getId();


    }

    @Override
    public AvatarProfileDto getContent(String username) {
        var avatar = avatarRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Avatar not found"));
        var dto = new AvatarProfileDto();
        BeanUtils.copyProperties(avatar, dto);
        return dto;

    }


    @Override
    public void deleteFile(String username) {
        avatarRepository.deleteByUsername(username);
    }


}

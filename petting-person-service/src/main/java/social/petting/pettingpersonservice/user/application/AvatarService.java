package social.petting.pettingpersonservice.user.application;

import pet.barker.pbpersonservice.user.domain.dto.AvatarProfileDto;
import pet.barker.pbpersonservice.user.domain.dto.AvatarUpdateDto;

import java.io.IOException;

public interface AvatarService {
    String setAvatar(AvatarUpdateDto dto) throws IOException;

    AvatarProfileDto getContent(String username);


    void deleteFile(String username);
}

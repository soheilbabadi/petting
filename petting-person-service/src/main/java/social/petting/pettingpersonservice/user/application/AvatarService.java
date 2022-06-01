package social.petting.pettingpersonservice.user.application;


import social.petting.pettingpersonservice.user.domain.dto.AvatarProfileDto;
import social.petting.pettingpersonservice.user.domain.dto.AvatarUpdateDto;

import java.io.IOException;

public interface AvatarService {
    String setAvatar(AvatarUpdateDto dto) throws IOException;

    AvatarProfileDto getContent(String username);


    void deleteFile(String username);
}

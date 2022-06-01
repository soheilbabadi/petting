package social.petting.pettingpersonservice.user.application;


import social.petting.pettingpersonservice.user.domain.dto.VerifyCodeDto;

public interface VerifyCodeService {
    String setCodeByEmail(String email);

    boolean verifyCodeByEmail(VerifyCodeDto dto);

    void deleteByEmail(String email);

    void deleteAll();
}

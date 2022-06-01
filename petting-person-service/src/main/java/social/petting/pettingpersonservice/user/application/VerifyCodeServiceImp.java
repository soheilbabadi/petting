package social.petting.pettingpersonservice.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import social.petting.pettingpersonservice.common.application.Utils;
import social.petting.pettingpersonservice.user.domain.VerifyCode;
import social.petting.pettingpersonservice.user.domain.dto.VerifyCodeDto;
import social.petting.pettingpersonservice.user.infra.VerifyCodeRepository;

@Service
public class VerifyCodeServiceImp implements VerifyCodeService {

    @Autowired
    private VerifyCodeRepository verifyCodeRepository;

    @Override
    public String setCodeByEmail(String email) {
        if (verifyCodeRepository.findByEmailAndExpireOnAfter(email, Utils.getUtc()).isPresent()) {
            return "";
        }
        String code = String.valueOf(Utils.getRandomInt(100000, 999999));
        var vrf = VerifyCode.builder()
                .code(code)
                .email(email)
                .expireOn(Utils.getUtc().plusMinutes(15))
                .createOn(Utils.getUtc())
                .build();
        return verifyCodeRepository.save(vrf).getCode();
    }

    @Override
    public boolean verifyCodeByEmail(VerifyCodeDto dto) {
        var vrf = verifyCodeRepository
                .findByEmailAndCodeAndExpireOnAfter(dto.getEmail(), dto.getCode(), Utils.getUtc()).isPresent();
        deleteAll();

        return vrf;

    }


    @Override
    public void deleteByEmail(String email) {
        verifyCodeRepository.deleteByEmailAndExpireOnBefore(email, Utils.getUtc());
        verifyCodeRepository.deleteAllByExpireOnBefore(Utils.getUtc());
    }

    @Override
    public void deleteAll() {
        verifyCodeRepository.deleteAllByExpireOnBefore(Utils.getUtc());
    }


}

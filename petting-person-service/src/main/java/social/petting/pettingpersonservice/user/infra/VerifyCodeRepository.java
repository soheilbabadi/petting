package social.petting.pettingpersonservice.user.infra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import social.petting.pettingpersonservice.user.domain.VerifyCode;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface VerifyCodeRepository extends CrudRepository<VerifyCode, Long> {
    Optional<VerifyCode> findByPhoneNumberAndCodeAndExpireOn(String phoneNumber, String code, LocalDateTime ExpireOn);

    Optional<VerifyCode> findByEmailAndCodeAndExpireOnAfter(String email, String code, LocalDateTime ExpireOn);

    Optional<VerifyCode> findByPhoneNumberAndExpireOnAfter(String phoneNumber, LocalDateTime ExpireOn);

    Optional<VerifyCode> findByEmailAndExpireOnAfter(String email, LocalDateTime ExpireOn);


    void deleteByPhoneNumberAndExpireOnBefore(String phoneNumber, LocalDateTime ExpireOn);

    void deleteByEmailAndExpireOnBefore(String email, LocalDateTime ExpireOn);

    void deleteAllByExpireOnBefore(LocalDateTime ExpireOn);

}

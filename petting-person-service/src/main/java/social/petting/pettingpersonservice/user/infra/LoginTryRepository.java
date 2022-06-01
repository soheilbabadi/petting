package social.petting.pettingpersonservice.user.infra;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import social.petting.pettingpersonservice.user.domain.LoginTry;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface LoginTryRepository extends CrudRepository<LoginTry, Long> {

    Optional<LoginTry> findAllByUsername(String username);

    Optional<LoginTry> findAllByUsernameAndIp(String username, String ip);

    Optional<LoginTry> findAllByUsernameAndIpAndLoginOnBetween(String username, String ip, LocalDateTime startOn, LocalDateTime endOn);

    Optional<LoginTry> findAllByUsernameAndLoginOnBetween(String username, LocalDateTime start, LocalDateTime end);

    void deleteAllByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM login_try WHERE username = ?1 AND login_on BETWEEN ?2 AND ?3", nativeQuery = true)
    int countLoginTryByUsernameAndLoginOnBetween(String username, LocalDateTime start, LocalDateTime end);


}

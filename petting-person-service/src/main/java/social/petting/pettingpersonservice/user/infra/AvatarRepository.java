package social.petting.pettingpersonservice.user.infra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pet.barker.pbpersonservice.user.domain.Avatar;

import java.util.Optional;

@Repository
public interface AvatarRepository extends CrudRepository<Avatar, Long> {


    Optional<Avatar> findByUsername(String username);


    void deleteByUsername(String username);
}

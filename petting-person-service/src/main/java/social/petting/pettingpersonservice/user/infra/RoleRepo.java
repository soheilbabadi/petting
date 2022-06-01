package social.petting.pettingpersonservice.user.infra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pet.barker.pbpersonservice.user.domain.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
}


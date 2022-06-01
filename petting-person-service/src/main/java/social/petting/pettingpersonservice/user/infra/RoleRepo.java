package social.petting.pettingpersonservice.user.infra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import social.petting.pettingpersonservice.user.domain.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
}


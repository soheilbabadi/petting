package social.petting.pettingpersonservice.common.Infra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pet.barker.pbpersonservice.common.domain.Lookup;

import java.util.List;

@Repository
public interface LookupRepository extends CrudRepository<Lookup, Long> {

    List<Lookup> findAllByLookupTypeOrderBySortOrder(String lookupType);

}

package social.petting.pettingpersonservice.user.infra;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pet.barker.pbpersonservice.user.domain.Person;

import java.util.Optional;

@Repository

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

    Optional<Person> findByUserId(String userId);

    Optional<Person> findByUsername(String username);

    Optional<Person> findByPhone(String phone);


    long countByEmail(String email);


    long countByUserId(String userId);

    long countByPhone(String phone);

    long countByUsername(String username);

    void deleteByUserId(String userId);


}

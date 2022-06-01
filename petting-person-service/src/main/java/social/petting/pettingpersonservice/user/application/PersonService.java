package social.petting.pettingpersonservice.user.application;

import pet.barker.pbpersonservice.user.domain.Person;
import pet.barker.pbpersonservice.user.domain.dto.*;

public interface PersonService {
    long getPersonCount();

    String createPerson(PersonCreateDto dto);

    long updateProfile(PersonUpdateDto dto);

    int deletePerson(String userId);

    Person getPerson(String userId);

    PersonProfileDto getPersonByUsername(String username);

    PersonProfileDto getPersonProfile(String username);


    Person getPersonByEmail(String email);

    Person getPersonByPhone(String phone);

    long countByEmail(String email);

    long countByPhone(String phone);

    long countByUsername(String username);

    long updatePassword(PasswordUpdateDto dto);

    String resetPassword(String username);

    String deactivate(String username);

    String activate(String username);

    String suspend(String username);

    String unsuspend(String username);

    PersonProfileDto login(PersonLoginDto dto);


}

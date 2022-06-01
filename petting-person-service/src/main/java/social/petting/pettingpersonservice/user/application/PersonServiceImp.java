package social.petting.pettingpersonservice.user.application;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import social.petting.pettingpersonservice.common.Infra.LookupRepository;
import social.petting.pettingpersonservice.common.application.Utils;
import social.petting.pettingpersonservice.common.exception.ErrorMessages;
import social.petting.pettingpersonservice.common.exception.UserException;
import social.petting.pettingpersonservice.user.domain.LoginTry;
import social.petting.pettingpersonservice.user.domain.Person;
import social.petting.pettingpersonservice.user.domain.dto.*;
import social.petting.pettingpersonservice.user.infra.LoginTryRepository;
import social.petting.pettingpersonservice.user.infra.PersonRepository;

@Service
public class PersonServiceImp implements PersonService {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LookupRepository lookupRepository;

    @Autowired
    private LoginTryRepository loginTryRepository;


    @Override
    public long getPersonCount() {
        return personRepository.count();
    }

    @Override
    public String createPerson(PersonCreateDto dto) {

        //validate request
        dto.setEmail(dto.getEmail().trim().toLowerCase());
        if (countByEmail(dto.getEmail()) > 0) {
            throw new UserException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
        }


        var current = Utils.getUtc();
        var locationId = lookupRepository.findById(dto.getLocationId()).stream().findFirst().get();
        var person = Person.builder()
                .createdOn(current)
                .avatar("https://picsum.photos/200")
                .bio("")
                .deactivated(false)
                .email(dto.getEmail())
                .lastLoginOn(current)
                .locationId(locationId)
                .modifiedOn(current)
                .nickName(dto.getNickName())
                .password(dto.getPassword())
                .salt("")
                .username(Utils.getRandomString(50))
                .phone("")
                .suspended(false)
                .userId(Utils.getRandomString(50))
                .verified(false)
                .suspended(false)
                .build();
        return personRepository.save(person).getUsername();
    }


    @Override
    public long updateProfile(PersonUpdateDto dto) {


        var person = getPerson(dto.getUserId());
        if (!person.getEmail().equals(dto.getEmail()) && countByEmail(dto.getEmail()) > 0) {
            throw new UserException(ErrorMessages.EMAIL_ALREADY_EXISTS.getErrorMessage());
        }

        if (!person.getUsername().equals(dto.getNickName()) && countByUsername(dto.getUsername()) > 0) {
            throw new UserException(ErrorMessages.USERNAME_ALREADY_EXISTS.getErrorMessage());
        }

        var current = Utils.getUtc();
        var locationId = lookupRepository.findById(dto.getLocationId()).stream().findFirst().get();


        BeanUtils.copyProperties(dto, person);
        person.setLocationId(locationId);
        person.setModifiedOn(current);


        return personRepository.save(person).getId();


    }

    @Override
    public int deletePerson(String userId) {
        personRepository.deleteByUserId(userId);
        return 1;
    }

    @Override
    public Person getPerson(String userId) {
        return personRepository.findByUserId(userId).stream().findFirst()
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));
    }

    @Override
    public PersonProfileDto getPersonByUsername(String username) {
        var entity = personRepository.findByUsername(username).stream().findFirst()
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));
        var result = new PersonProfileDto();
        BeanUtils.copyProperties(entity, result);
        return result;
    }

    @Override
    public PersonProfileDto getPersonProfile(String username) {
        var person = personRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));
        var result = new PersonProfileDto();
        BeanUtils.copyProperties(person, result);
        result.setEmail("");

        result.setUserId("");


        return result;
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findByEmail(email).stream().findFirst()
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));
    }

    @Override
    public Person getPersonByPhone(String phone) {
        return personRepository.findByPhone(phone).stream().findFirst()
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));
    }


    @Override
    public long countByEmail(String email) {
        return personRepository.countByEmail(email);
    }

    @Override
    public long countByPhone(String phone) {
        return personRepository.countByPhone(phone);
    }

    @Override
    public long countByUsername(String username) {

        return personRepository.countByUsername(username);
    }

    @Override
    public long updatePassword(PasswordUpdateDto dto) {
        var current = Utils.getUtc();
        var person = personRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));

        if (person.getPassword().equals(dto.getOldPassword())) {
            person.setPassword(dto.getNewPassword());
            person.setModifiedOn(current);
            return personRepository.save(person).getId();
        }
        return 0L;
    }

    @Override
    public String resetPassword(String username) {
        var person = personRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));

        var newPassword = Utils.getRandomString(10);
        person.setPassword(newPassword);
        personRepository.save(person);
        return newPassword;
    }

    @Override
    public String deactivate(String username) {
        var person = personRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));
        person.setSuspended(true);
        person.setDeactivated(true);
        person.setLocked(true);

        return personRepository.save(person).getUserId();
    }

    @Override
    public String activate(String username) {
        var person = personRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));
        person.setSuspended(false);
        person.setDeactivated(false);
        person.setLocked(false);
        return personRepository.save(person).getUserId();
    }

    @Override
    public String suspend(String username) {
        var person = personRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));

        person.setSuspended(true);
        person.setDeactivated(true);
        person.setLocked(true);
        return personRepository.save(person).getUserId();
    }

    @Override
    public String unsuspend(String username) {
        var person = personRepository.findByUsername(username)
                .orElseThrow(() -> new UserException(ErrorMessages.USER_NOT_EXIST.getErrorMessage()));

        person.setSuspended(false);
        person.setDeactivated(false);
        person.setLocked(false);
        return personRepository.save(person).getUserId();
    }

    @Override
    public PersonProfileDto login(PersonLoginDto dto) {


        var person = getPersonByEmail(dto.getEmail());


        var loginTry = new LoginTry();
        loginTry.setUsername(person.getUsername());
        loginTry.setLoginOn(Utils.getUtc());

        loginTry.setUserAgent(dto.getUserAgent());
        loginTry.setBrowser(dto.getBrowser());
        loginTry.setOs(dto.getOs());
        loginTry.setIp(dto.getIp());


        if (person.isLocked()) {
            throw new UserException(ErrorMessages.USER_LOCKED.getErrorMessage());
        }
        if (person.isSuspended()) {
            throw new UserException(ErrorMessages.USER_SUSPENDED.getErrorMessage());
        }
        if (person.isDeactivated()) {
            throw new UserException(ErrorMessages.USER_DEACTIVATED.getErrorMessage());
        }
        if (!person.getPassword().equals(dto.getPassword())) {


            loginTry.setLoginSuccess(false);
            loginTryRepository.save(loginTry);

            if (loginTryRepository.countLoginTryByUsernameAndLoginOnBetween(person.getUsername(), Utils.getUtc().minusMinutes(5), Utils.getUtc()) > 5) {
                person.setLocked(true);
                personRepository.save(person);
            }

            throw new UserException(ErrorMessages.WRONG_PASSWORD.getErrorMessage());
        }
        //log try


        loginTry.setLoginSuccess(true);
        loginTryRepository.save(loginTry);


        return getPersonProfile(person.getUsername());

    }

}
package social.petting.pettingpersonservice.user.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pet.barker.pbpersonservice.user.application.PersonService;
import pet.barker.pbpersonservice.user.domain.Person;
import pet.barker.pbpersonservice.user.domain.dto.PersonCreateDto;
import pet.barker.pbpersonservice.user.domain.dto.PersonUpdateDto;

@RestController("personController")
@RequestMapping(path = "/api/v1/person", produces = "application/json"
        , consumes = "application/json"
        , headers = "Accept=application/json", name = "person")

public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/{username}")
    public Person getPerson(@PathVariable("username") String username) {
        return personService.getPerson(username);
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody PersonCreateDto dto) {
        return new ResponseEntity<String>(personService.createPerson(dto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Long> updatePerson(@RequestBody PersonUpdateDto person) {
        return new ResponseEntity<>(personService.updateProfile(person), HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public void deletePerson(@PathVariable("username") String username) {
        personService. (username);
    }
}


}

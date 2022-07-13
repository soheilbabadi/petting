package social.petting.pettingchannelservice.channel.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import social.petting.pettingchannelservice.channel.domain.ChannelDto;

import javax.validation.ConstraintDeclarationException;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    @PostMapping(path = "/create")
    public ResponseEntity createChannel(@RequestBody ChannelDto dto) {
        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateChannel(@RequestBody ChannelDto dto) {
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteChannel(@PathVariable long id) {
        return new ResponseEntity(id, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity getChannel(@PathVariable long id) {
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @GetMapping("/find/{keyword}")
    public ResponseEntity findChannel(@PathVariable String keyword) {
        return new ResponseEntity(keyword, HttpStatus.OK);
    }

    @RequestMapping("/list")
    public ResponseEntity listChannel() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler(ConstraintDeclarationException.class)
    public ResponseEntity handleConstraintDeclarationException(ConstraintDeclarationException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

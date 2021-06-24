package one.digitalinnovation.personapi.controller;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    private PersonRepository personRepository;

    @Autowired
    public PersonController (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("create person with ID" + savedPerson.getId())
                . build();
    }
}

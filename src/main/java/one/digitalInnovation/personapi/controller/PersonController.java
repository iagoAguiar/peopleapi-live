package one.digitalInnovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalInnovation.personapi.dto.MessageResponseDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.repository.PersonRepository;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping
	public MessageResponseDTO createPerson(@RequestBody  Person person) {		
		
		Person savedPerson = personRepository.save(person);
		
		
		return MessageResponseDTO
				.builder()
				.message("Created person with ID" + savedPerson.getId())
				.build();
	}
	
	
	
	
}

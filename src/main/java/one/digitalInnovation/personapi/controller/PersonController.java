package one.digitalInnovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalInnovation.personapi.dto.MessageResponseDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.service.PersonService;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;
	
	
	
	
	
	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody  Person person) {		
		
		return personService.createPerson(person);
		
	}
	
	
	
	
}

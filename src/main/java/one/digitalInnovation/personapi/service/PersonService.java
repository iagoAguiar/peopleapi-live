package one.digitalInnovation.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalInnovation.personapi.dto.MessageResponseDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	
	public MessageResponseDTO createPerson(Person person) {		
		
		Person savedPerson = personRepository.save(person);
		
		
		return MessageResponseDTO
				.builder()
				.message("Created person with ID: " + savedPerson.getId())
				.build();
	}
	



}

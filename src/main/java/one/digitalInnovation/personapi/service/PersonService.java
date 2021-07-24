package one.digitalInnovation.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalInnovation.personapi.dto.MessageResponseDTO;
import one.digitalInnovation.personapi.dto.PersonDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.mapper.PersonMapper;
import one.digitalInnovation.personapi.repository.PersonRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	 private PersonRepository personRepository;

	 private final PersonMapper personMapper;


	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		   Person person = personMapper.toModel(personDTO);
	        Person savedPerson = personRepository.save(person);

	        MessageResponseDTO messageResponse = createMessageResponse("Person successfully created with ID ", savedPerson.getId());

	        return messageResponse;
	    }
	  
	private MessageResponseDTO createMessageResponse(String message, Long id ) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }


}
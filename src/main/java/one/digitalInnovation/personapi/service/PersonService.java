package one.digitalInnovation.personapi.service;

import one.digitalInnovation.personapi.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalInnovation.personapi.dto.MessageResponseDTO;
import one.digitalInnovation.personapi.dto.PersonDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.mapper.PersonMapper;
import one.digitalInnovation.personapi.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

	 private PersonRepository personRepository;

	 private final PersonMapper personMapper = PersonMapper.INSTANCE;


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


	public List<PersonDTO> listALL() {
		List<Person> allPeople = personRepository.findAll();

		return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}


	public PersonDTO findById(Long id) throws PersonNotFoundException {
		//Optional<Person> optionalPerson = personRepository.findById(id);
		Person person = verifyIfExists(id);

		return personMapper.toDTO(person);
	}

	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepository.deleteById(id);
	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}


}







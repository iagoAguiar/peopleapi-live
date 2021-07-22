package one.digitalInnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalInnovation.personapi.entity.Person;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	
	@GetMapping
	public String getBook() {
		
		Person person = new Person();
		
		person.getId();
		return "API Test!";
	}
	
	
	
	
}

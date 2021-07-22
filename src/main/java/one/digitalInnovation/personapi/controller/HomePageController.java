package one.digitalInnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomePageController {

	@GetMapping
	public String getHomePage() {
		return "Bem vindo a página inicial!!";
	}
	
}

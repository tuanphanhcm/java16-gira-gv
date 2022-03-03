package cybersoft.javabackend.java16giragv.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping
	public Object welcome() {
		return "Welcome to Gira Application";
	}
}

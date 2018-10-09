package hr.vodovod.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hr.vodovod.model.Person;
import hr.vodovod.services.PersonService;

@RestController
@RequestMapping("person")
@CrossOrigin(origins="http://localhost:4200")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/{oib}")
	public Person findPersonByOib(@PathVariable String oib) {
		return personService.findByOib(oib);
	}
}

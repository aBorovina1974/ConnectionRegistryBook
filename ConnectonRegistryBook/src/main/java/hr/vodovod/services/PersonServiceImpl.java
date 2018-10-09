package hr.vodovod.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hr.vodovod.jpa.repositories.PersonRepository;
import hr.vodovod.model.Person;

@Service
public class PersonServiceImpl implements PersonService{
	
    @Autowired
    PersonRepository personRepository;

	@Override
	public Person findByOib(String oib) {
		return personRepository.findByOib(oib);
	}
}

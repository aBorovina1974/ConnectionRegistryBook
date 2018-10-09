package hr.vodovod.services;

import hr.vodovod.model.Person;

public interface PersonService {
	
	Person findByOib(String oib);
}

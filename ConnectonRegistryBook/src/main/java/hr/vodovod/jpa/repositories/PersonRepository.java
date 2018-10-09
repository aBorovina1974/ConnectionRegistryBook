package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	Person findByOib(String oib);
}

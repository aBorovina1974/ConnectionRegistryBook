package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, Integer> {

}

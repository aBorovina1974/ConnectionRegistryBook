package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}

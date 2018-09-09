package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.vodovod.model.Modification;

@Repository
public interface ModificationRepository extends JpaRepository<Modification, Integer>{

}

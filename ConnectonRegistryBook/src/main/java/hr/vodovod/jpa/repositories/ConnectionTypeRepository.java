package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.RequestType;

public interface ConnectionTypeRepository extends JpaRepository<RequestType, Integer> {

}

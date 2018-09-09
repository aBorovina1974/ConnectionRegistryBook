package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.RequestPurpose;

public interface RequestPurposeRepository extends JpaRepository<RequestPurpose, Integer> {

}

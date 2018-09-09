package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

}

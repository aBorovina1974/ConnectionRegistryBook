package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.ConnectionHistory;

public interface ConnectionHistoryRepository extends JpaRepository<ConnectionHistory, Integer> {

}

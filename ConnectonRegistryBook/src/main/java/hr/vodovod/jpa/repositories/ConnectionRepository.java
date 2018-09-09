package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import hr.vodovod.model.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Integer> {
	@Query("SELECT c FROM Connection c WHERE c.requestForm.id = :requestFormId")
	public Connection getConnectionByRequest(@Param("requestFormId") Integer requestId);
}

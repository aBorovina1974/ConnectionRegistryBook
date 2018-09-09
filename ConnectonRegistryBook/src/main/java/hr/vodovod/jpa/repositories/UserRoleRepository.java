package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}

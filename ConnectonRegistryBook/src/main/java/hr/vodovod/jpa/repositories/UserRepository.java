package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}

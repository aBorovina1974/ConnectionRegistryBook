package hr.vodovod.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.vodovod.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}

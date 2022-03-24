package cybersoft.javabackend.java16giragv.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16giragv.user.model.GiraUser;

@Repository
public interface GiraUserRepository extends JpaRepository<GiraUser, UUID> {
	
	@Query("SELECT u FROM GiraUser u LEFT JOIN FETCH u.groups WHERE u.username = ?1")
	Optional<GiraUser> findByUsername(String username);

	Optional<GiraUser> findByEmail(String email);
	
	Optional<GiraUser> findByEmailAndUsername(String email, String username);
}

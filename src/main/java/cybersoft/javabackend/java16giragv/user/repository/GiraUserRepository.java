package cybersoft.javabackend.java16giragv.user.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16giragv.user.dto.GiraUserRolesDTO;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserWithRolesDTO;
import cybersoft.javabackend.java16giragv.user.model.GiraUser;

@Repository
public interface GiraUserRepository extends JpaRepository<GiraUser, UUID> {
	
	@Query("SELECT u FROM GiraUser u LEFT JOIN FETCH u.groups WHERE u.username = ?1")
	Optional<GiraUser> findByUsername(String username);

	Optional<GiraUser> findByEmail(String email);
	
	Optional<GiraUser> findByEmailAndUsername(String email, String username);

	@Query("SELECT r.id as id, r.code as code, r.description as description FROM GiraUser u LEFT JOIN u.groups g LEFT JOIN g.roles r WHERE u.username = ?1")
	List<GiraUserRolesDTO> findUserWithRolesByUsername(String username);
	
	@Query("SELECT u FROM GiraUser u LEFT JOIN u.groups g LEFT JOIN g.roles r WHERE u.username = ?1")
	GiraUser findUserRolesByUsername(String username);
	
	// ad-hoc entity graph
	@EntityGraph(attributePaths = {"groups.roles"}, type = EntityGraphType.FETCH)
	@Query("SELECT u FROM GiraUser u WHERE u.username = ?1")
	GiraUser findUserRolesByUsernameEntityGraph(String username);
}

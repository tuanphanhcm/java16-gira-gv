package cybersoft.javabackend.java16giragv.role.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java16giragv.role.model.GiraProgram;

@Repository
public interface GiraProgramRepository extends JpaRepository<GiraProgram, UUID> {

	@Query("SELECT p FROM GiraProgram p LEFT JOIN p.roles r LEFT JOIN r.groups g LEFT JOIN g.users u WHERE u.username = ?2 AND p.name = ?1")
	List<GiraProgram> findProgramByNameAndUsername(String name, String username);
}

package cybersoft.javabackend.java16giragv.role.repository;

import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GiraRoleRepository extends JpaRepository<GiraRole, UUID> {

    Optional<GiraRole> findByCode(String code);

}

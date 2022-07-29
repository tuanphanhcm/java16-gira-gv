package cybersoft.javabackend.java16giragv.role.repository;

import cybersoft.javabackend.java16giragv.role.model.GiraGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GiraGroupRepository extends JpaRepository<GiraGroup, UUID> {

    // JPQL
    @Query("SELECT g FROM GiraGroup g JOIN g.roles WHERE g.id = ?1")
    GiraGroup findGroupWithRolesByGroupId(UUID groupId);

}

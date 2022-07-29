package cybersoft.javabackend.java16giragv.role.repository;

import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@Transactional
public class GiraRoleRepositoryTest {

    @Autowired
    private GiraRoleRepository repository;

    @Test
    public void shouldNotInsertRole() {
        GiraRole role = GiraRole.builder()
                .code("FIVEH")
                .description("Description")
                .build();

        assertDoesNotThrow(() -> repository.save(role));
    }
}

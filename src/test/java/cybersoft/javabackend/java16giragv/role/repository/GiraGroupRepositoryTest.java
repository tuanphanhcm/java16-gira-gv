package cybersoft.javabackend.java16giragv.role.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class GiraGroupRepositoryTest {

    @Autowired
    private GiraGroupRepository repository;

    @BeforeAll
    public void setup() {

    }

    @Test
    void shouldFetchGroupWithRoles() {
        assertDoesNotThrow(() -> {
            repository.findGroupWithRolesByGroupId(UUID.fromString("a07a7c52-97ff-4423-9ca7-6eaec6c1ba3a"));
        });
    }
}

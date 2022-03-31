package cybersoft.javabackend.java16giragv.role.repository;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class GiraGroupRepositoryTest {

	@Autowired
	private GiraGroupRepository repository;
	
	@BeforeAll
	public void setup () {
		
	}
	
	@Test
	public void shouldFetchGroupWithRoles () {
		assertDoesNotThrow( () -> {
			repository.findGroupWithRolesByGroupId(UUID.fromString("a07a7c52-97ff-4423-9ca7-6eaec6c1ba3a"));
		});
	}
}

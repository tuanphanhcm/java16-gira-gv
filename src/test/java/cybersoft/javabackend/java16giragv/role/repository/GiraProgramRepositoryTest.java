package cybersoft.javabackend.java16giragv.role.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cybersoft.javabackend.java16giragv.role.model.GiraProgram;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class GiraProgramRepositoryTest {
	@Autowired
	private GiraProgramRepository repository;
	
	@Test
	public void shouldReturnProgram () {
		List<GiraProgram> programs = repository.findProgramByNameAndUsername("findAllPrograms", "tuanphan");
		log.info("Size of list: " + programs.size());
		log.info("Programs: " + programs.toString() );
		
		assertEquals(0, programs.size());
	}
}

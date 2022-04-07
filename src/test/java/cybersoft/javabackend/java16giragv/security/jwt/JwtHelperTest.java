package cybersoft.javabackend.java16giragv.security.jwt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtHelperTest {
	
	@Autowired
	private JwtHelper helper;
	
	@Test
	public void shouldBeInjectedSuccessfully() {
		assertNotNull(helper);
	}
}

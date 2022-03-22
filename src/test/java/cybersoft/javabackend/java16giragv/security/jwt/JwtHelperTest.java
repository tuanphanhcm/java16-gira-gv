package cybersoft.javabackend.java16giragv.security.jwt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import cybersoft.javabackend.java16giragv.user.model.GiraUser;

@SpringBootTest
public class JwtHelperTest {
	
	@Autowired
	private JwtHelper helper;
	
	@Test
	public void shouldBeInjectedSuccessfully() {
		assertNotNull(helper);
	}
}

package cybersoft.javabackend.java16giragv.security.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JwtHelperTest {

    @Autowired
    private JwtHelper helper;

    @Test
    public void shouldBeInjectedSuccessfully() {

        assertThat(helper).isNotNull();
    }
}

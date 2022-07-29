package cybersoft.javabackend.java16giragv.security.service;

import cybersoft.javabackend.java16giragv.security.dto.LoginDTO;
import cybersoft.javabackend.java16giragv.security.jwt.JwtHelper;
import cybersoft.javabackend.java16giragv.user.model.GiraUser;
import cybersoft.javabackend.java16giragv.user.repository.GiraUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final GiraUserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtHelper jwts;

    public AuthServiceImpl(GiraUserRepository repository, PasswordEncoder passwordEncoder, JwtHelper jwts) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwts = jwts;
    }

    @Override
    public String login(LoginDTO dto) {
        // get user information
        Optional<GiraUser> userOpt = repository.findByUsername(dto.getUsername());

        // check password
        String encodedPassword = userOpt.map(GiraUser::getPassword).orElseThrow();

        if (passwordEncoder.matches(dto.getPassword(), encodedPassword)) {
            return jwts.generateJwtToken(dto.getUsername());
        }

        return null;
    }

}

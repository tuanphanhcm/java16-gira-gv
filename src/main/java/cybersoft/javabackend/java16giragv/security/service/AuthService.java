package cybersoft.javabackend.java16giragv.security.service;

import cybersoft.javabackend.java16giragv.security.dto.LoginDTO;

public interface AuthService {
	String login(LoginDTO dto);
}

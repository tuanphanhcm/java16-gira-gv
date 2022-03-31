package cybersoft.javabackend.java16giragv.user.service;

import java.util.List;

import cybersoft.javabackend.java16giragv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserRolesDTO;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserWithRolesDTO;

public interface GiraUserService {
	GiraUserDTO createNewUser(GiraUserDTO dto);

	List<GiraUserRolesDTO> findUserWithRolesByUsername(String username);

	GiraUserWithRolesDTO findUserWithRolesByUsernameUsingJoin(String username);
}

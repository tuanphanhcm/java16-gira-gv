package cybersoft.javabackend.java16giragv.user.service;

import cybersoft.javabackend.java16giragv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserRolesDTO;
import cybersoft.javabackend.java16giragv.user.dto.GiraUserWithRolesDTO;

import java.util.List;

public interface GiraUserService {
    GiraUserDTO createNewUser(GiraUserDTO dto);

    List<GiraUserRolesDTO> findUserWithRolesByUsername(String username);

    GiraUserWithRolesDTO findUserWithRolesByUsernameUsingJoin(String username);
}

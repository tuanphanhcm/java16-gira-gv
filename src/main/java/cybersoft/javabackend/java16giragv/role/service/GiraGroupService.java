package cybersoft.javabackend.java16giragv.role.service;

import cybersoft.javabackend.java16giragv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giragv.role.dto.GiraGroupWithRolesDTO;

import java.util.List;

public interface GiraGroupService {
    List<GiraGroupDTO> findAllDto();

    GiraGroupDTO createNewGroup(GiraGroupDTO dto);

    GiraGroupWithRolesDTO addRole(String groupId, String roleId);

    GiraGroupWithRolesDTO removeRole(String groupId, String roleId);

    GiraGroupWithRolesDTO findById(String groupId);
}

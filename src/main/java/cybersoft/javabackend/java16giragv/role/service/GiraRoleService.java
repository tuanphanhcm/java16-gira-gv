package cybersoft.javabackend.java16giragv.role.service;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface GiraRoleService {
    List<GiraRoleDTO> findAllEntity();

    GiraRole save(GiraRoleDTO dto);

    GiraRole update(UUID id, @Valid GiraRoleDTO dto);

    GiraRole findById(String id);
}

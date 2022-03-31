package cybersoft.javabackend.java16giragv.role.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRoleDTO> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
	GiraRole update(UUID id, @Valid GiraRoleDTO dto);
	GiraRole findById(String id);
}

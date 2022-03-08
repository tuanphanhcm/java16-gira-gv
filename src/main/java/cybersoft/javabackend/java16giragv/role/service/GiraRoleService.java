package cybersoft.javabackend.java16giragv.role.service;

import java.util.List;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;

public interface GiraRoleService {
	List<GiraRole> findAllEntity();
	GiraRole save(GiraRoleDTO dto);
}

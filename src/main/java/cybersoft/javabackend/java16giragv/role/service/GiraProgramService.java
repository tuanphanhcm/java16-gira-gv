package cybersoft.javabackend.java16giragv.role.service;

import java.util.List;

import cybersoft.javabackend.java16giragv.role.dto.GiraProgramDTO;

public interface GiraProgramService {
	GiraProgramDTO save(GiraProgramDTO dto);
	List<GiraProgramDTO> findAllPrograms ();
}

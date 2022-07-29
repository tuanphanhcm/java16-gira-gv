package cybersoft.javabackend.java16giragv.role.service;

import cybersoft.javabackend.java16giragv.role.dto.GiraProgramDTO;

import java.util.List;

public interface GiraProgramService {
    GiraProgramDTO save(GiraProgramDTO dto);

    List<GiraProgramDTO> findAllPrograms();
}

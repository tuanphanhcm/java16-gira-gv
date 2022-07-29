package cybersoft.javabackend.java16giragv.role.mapper;

import cybersoft.javabackend.java16giragv.role.dto.GiraProgramDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraProgram;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GiraProgramMapper {
    GiraProgramMapper INSTANCE = Mappers.getMapper(GiraProgramMapper.class);

    GiraProgramDTO toDTO(GiraProgram model);

    GiraProgram toModel(GiraProgramDTO dto);
}

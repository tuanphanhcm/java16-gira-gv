package cybersoft.javabackend.java16giragv.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giragv.role.dto.GiraProgramDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraProgram;

@Mapper
public interface GiraProgramMapper {
	GiraProgramMapper INSTANCE = Mappers.getMapper(GiraProgramMapper.class);
	
	GiraProgramDTO toDTO(GiraProgram model);
	GiraProgram toModel(GiraProgramDTO dto);
}

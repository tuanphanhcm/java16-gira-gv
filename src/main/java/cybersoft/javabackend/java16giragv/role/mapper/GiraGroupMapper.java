package cybersoft.javabackend.java16giragv.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cybersoft.javabackend.java16giragv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraGroup;

@Mapper
public interface GiraGroupMapper {
	GiraGroupMapper INSTANCE = Mappers.getMapper(GiraGroupMapper.class);
	
	GiraGroupDTO toDTO(GiraGroup model);
	GiraGroup toModel(GiraGroupDTO dto);
}

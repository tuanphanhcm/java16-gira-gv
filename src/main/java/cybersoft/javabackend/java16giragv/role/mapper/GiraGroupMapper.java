package cybersoft.javabackend.java16giragv.role.mapper;

import cybersoft.javabackend.java16giragv.role.dto.GiraGroupDTO;
import cybersoft.javabackend.java16giragv.role.dto.GiraGroupWithRolesDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraGroup;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GiraGroupMapper {
    GiraGroupMapper INSTANCE = Mappers.getMapper(GiraGroupMapper.class);

    GiraGroupDTO toDTO(GiraGroup model);

    GiraGroup toModel(GiraGroupDTO dto);

    GiraGroupWithRolesDTO toDtoWithRoles(GiraGroup modifiedGroup);
}

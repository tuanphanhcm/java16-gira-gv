package cybersoft.javabackend.java16giragv.role.mapper;


import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import cybersoft.javabackend.java16giragv.role.model.GiraRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GiraRoleMapper {
    GiraRoleMapper INSTANCE = Mappers.getMapper(GiraRoleMapper.class);

    GiraRole mapToEntity(GiraRoleDTO dto);

    GiraRoleDTO toGiraRoleDTO(GiraRole role);
}

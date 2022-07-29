package cybersoft.javabackend.java16giragv.user.mapper;

import cybersoft.javabackend.java16giragv.user.dto.GiraUserDTO;
import cybersoft.javabackend.java16giragv.user.model.GiraUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GiraUserMapper {
    GiraUserMapper INSTANCE = Mappers.getMapper(GiraUserMapper.class);

    GiraUser toModel(GiraUserDTO dto);

    GiraUserDTO toDTO(GiraUser model);
}

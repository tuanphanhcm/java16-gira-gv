package cybersoft.javabackend.java16giragv.role.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class GiraGroupWithRolesDTO {
    Set<GiraRoleDTO> roles;
    private UUID id;
    private String code;
    private String description;
}

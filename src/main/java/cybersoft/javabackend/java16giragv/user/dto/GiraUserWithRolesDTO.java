package cybersoft.javabackend.java16giragv.user.dto;

import cybersoft.javabackend.java16giragv.role.dto.GiraRoleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GiraUserWithRolesDTO {
    private UUID id;
    private String username;
    private String displayName;
    private String email;
    private List<GiraRoleDTO> roles;
}

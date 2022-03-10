package cybersoft.javabackend.java16giragv.role.dto;

import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiraGroupWithRolesDTO {
	private UUID id;
	
	private String code;
	
	private String description;
	
	Set<GiraRoleDTO> roles;
}

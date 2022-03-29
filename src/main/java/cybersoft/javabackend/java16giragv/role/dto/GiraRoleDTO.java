package cybersoft.javabackend.java16giragv.role.dto;

import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;

@Getter
@Setter
public class GiraRoleDTO {
	@Size(min = 5, max = 100, message = "Role Code must be 5 characters.")
	private String code;
	
	@NotBlank(message = "Description must be not blank.")
	private String description;
}

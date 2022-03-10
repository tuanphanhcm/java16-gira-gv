package cybersoft.javabackend.java16giragv.role.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GiraGroupDTO {
	private UUID id;
	
	@Size(min = 5, max = 36, message = "Group Code must be longer than 5 characters.")
	private String code;
	
	@NotBlank(message = "Description must be not blank.")
	private String description;
}

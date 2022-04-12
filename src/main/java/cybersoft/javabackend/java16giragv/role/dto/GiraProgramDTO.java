package cybersoft.javabackend.java16giragv.role.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import cybersoft.javabackend.java16giragv.role.model.GiraModule;
import cybersoft.javabackend.java16giragv.role.model.GiraProgramType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class GiraProgramDTO {
	@NotBlank
	private String name;
	
	@NotNull
	private GiraModule module;
	
	@NotNull
	private GiraProgramType type;
	
	@NotBlank
	private String description;
}

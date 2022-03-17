package cybersoft.javabackend.java16giragv.user.dto;

import javax.validation.constraints.Size;

import cybersoft.javabackend.java16giragv.user.model.UserStatus;
import cybersoft.javabackend.java16giragv.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GiraUserDTO {
	// mandatory
	@Size(min = 3, max = 100, message = "{user.username.size}")
	@UniqueUsername(message = "{user.username.existed}")
	private String username;
	
	private String password;
	
	private String displayName;
	
	private String email;
	
	private UserStatus status;
}

package cybersoft.javabackend.java16giragv.user.dto;

import cybersoft.javabackend.java16giragv.user.model.UserStatus;
import cybersoft.javabackend.java16giragv.user.validation.annotation.UniqueEmail;
import cybersoft.javabackend.java16giragv.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class GiraUserDTO {
    // mandatory
    @Size(min = 3, max = 100, message = "{user.username.size}")
    @UniqueUsername(message = "{user.username.existed}")
    @NotBlank
    private String username;

    private String password;

    private String displayName;

    @UniqueEmail(message = "{user.email.existed}")
    @NotBlank
    private String email;

    private UserStatus status;
}

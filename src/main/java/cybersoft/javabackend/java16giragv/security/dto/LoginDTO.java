package cybersoft.javabackend.java16giragv.security.dto;

import cybersoft.javabackend.java16giragv.security.validation.ExistedUser;
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
public class LoginDTO {
    @NotBlank(message = "{security.login.username.notblank}")
    @Size(min = 3, max = 100, message = "{user.username.size}")
    @ExistedUser(message = "{security.login.username.notexisted}")
    private String username;

    @NotBlank(message = "{security.login.password.notblank}")
    private String password;
}

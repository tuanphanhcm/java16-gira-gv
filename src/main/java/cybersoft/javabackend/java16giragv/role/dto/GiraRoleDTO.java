package cybersoft.javabackend.java16giragv.role.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
public class GiraRoleDTO {
    private UUID id;

    @Size(min = 5, max = 100, message = "Role Code must be 5 characters.")
    private String code;

    @NotBlank(message = "Description must be not blank.")
    private String description;
}

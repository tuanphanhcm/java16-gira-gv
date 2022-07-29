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
public class GiraGroupDTO {
    private UUID id;

    @Size(min = 5, max = 36, message = "{group.code.size}")
    private String code;

    @NotBlank(message = "{group.description.notblank}")
    private String description;
}

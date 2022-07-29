package cybersoft.javabackend.java16giragv.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cybersoft.javabackend.java16giragv.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_role")
public class GiraRole extends BaseEntity {
    // constraint: 5 character
    @Size(min = 5, max = 100)
    private String code;

    @NotBlank
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<GiraGroup> groups = new LinkedHashSet();

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "gira_role_program",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "program_id")
    )
    private Set<GiraProgram> programs = new LinkedHashSet();
}

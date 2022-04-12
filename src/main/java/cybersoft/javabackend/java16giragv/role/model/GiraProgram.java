package cybersoft.javabackend.java16giragv.role.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java16giragv.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_program")
public class GiraProgram extends BaseEntity {
	@NotBlank
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private GiraModule module;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "program_type")
	private GiraProgramType type;
	
	@NotBlank
	private String description;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "programs")
	private Set<GiraRole> roles = new LinkedHashSet();
}

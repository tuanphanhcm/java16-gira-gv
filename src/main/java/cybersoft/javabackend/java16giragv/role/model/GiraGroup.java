package cybersoft.javabackend.java16giragv.role.model;

import cybersoft.javabackend.java16giragv.common.model.BaseEntity;
import cybersoft.javabackend.java16giragv.user.model.GiraUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_group")
public class GiraGroup extends BaseEntity {
    // id, code, description, roles

    private String code;
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "gira_group_role",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<GiraRole> roles = new LinkedHashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "gira_group_user",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<GiraUser> users = new LinkedHashSet<>();

    public void addRole(GiraRole role) {
        roles.add(role);
        role.getGroups().add(this);
    }

    public void removeRole(GiraRole role) {
        roles.remove(role);
        role.getGroups().remove(this);
    }

    public void clearRole() {
        this.roles.clear();
    }
}

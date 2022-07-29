package cybersoft.javabackend.java16giragv.user.model;

import cybersoft.javabackend.java16giragv.common.model.BaseEntity;
import cybersoft.javabackend.java16giragv.role.model.GiraGroup;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "gira_user")
public class GiraUser extends BaseEntity {

    @ManyToMany(mappedBy = "users")
    private Set<GiraGroup> groups = new LinkedHashSet<GiraGroup>();

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "display_name", nullable = false)
    private String displayName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "department")
    private String department;

    @Column(name = "major")
    private String major;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "facebook")
    private String facebook;
}

package br.com.vsn.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="tb_user")
@Entity(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String passwordHash;
    private String tempRole;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="tenant_id", nullable=false)
    private Tenant tenant;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_role_user",
            joinColumns = {
                    @JoinColumn(name =  "userId", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name =  "roleId", referencedColumnName = "id")
            }
    )
    private List<Role> roles;
}

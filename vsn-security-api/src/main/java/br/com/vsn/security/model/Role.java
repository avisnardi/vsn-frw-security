package br.com.vsn.security.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name="tb_role")
@Entity(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String Name;

    @ManyToOne
    @JoinColumn(name="tenant_id", nullable=false)
    private Tenant tenant;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_role_user",
            joinColumns = {
                    @JoinColumn(name =  "roleId", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name =  "userId", referencedColumnName = "id")
            }
            )
    private List<User> users;
}

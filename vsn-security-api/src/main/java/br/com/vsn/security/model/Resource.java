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
@Table(name="tb_resource")
@Entity(name="resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private String description;

    @ManyToOne
    @JoinColumn(name="application_id", nullable=false)
    private Application application;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tb_resource_role",
            joinColumns = {
                    @JoinColumn(name =  "resourceId", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name =  "roleId", referencedColumnName = "id")
            }
    )
    private List<Role> roles;
}

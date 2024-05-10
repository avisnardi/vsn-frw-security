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
@Table(name="tb_tenant")
@Entity(name="tenant")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String code;

    @OneToMany(mappedBy="tenant")
    private List<User> user;

    @OneToMany(mappedBy="tenant")
    private List<Role> role;
}

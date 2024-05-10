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
@Table(name="tb_application")
@Entity(name="application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy="application")
    private List<Resource> resource;
}

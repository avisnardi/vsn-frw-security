package br.com.vsn.security.model;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {
        private String login;
        private String password;
        private String email;
        private String tempRole;
}

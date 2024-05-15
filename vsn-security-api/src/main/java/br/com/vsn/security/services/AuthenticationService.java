package br.com.vsn.security.services;

import br.com.vsn.security.config.SecurityConfiguration;
import br.com.vsn.security.model.AuthenticationDTO;
import br.com.vsn.security.model.TokenDTO;
import br.com.vsn.security.model.User;
import br.com.vsn.security.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService jwtTokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    // Método responsável por autenticar um usuário e retornar um token JWT
    public TokenDTO authenticateUser(AuthenticationDTO authenticationDTO) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new TokenDTO(jwtTokenService.generateToken(userDetails));

    }


}

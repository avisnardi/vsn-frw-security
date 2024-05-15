package br.com.vsn.security.controller;

import br.com.vsn.security.model.AuthenticationDTO;
import br.com.vsn.security.model.LoginResponseDTO;
import br.com.vsn.security.model.TokenDTO;
import br.com.vsn.security.model.UserDetailsImpl;
import br.com.vsn.security.services.AuthenticationService;
import br.com.vsn.security.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        String token = authenticationService.authenticateUser(authenticationDTO).token();
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}

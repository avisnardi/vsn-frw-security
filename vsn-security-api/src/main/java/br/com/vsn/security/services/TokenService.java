package br.com.vsn.security.services;

import br.com.vsn.security.model.UserDetailsImpl;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private  String secret;

    @Value("${api.security.token.issuer}")
    private  String issuer;

    @Value("${api.security.token.expirationTime}")
    private  String expirationTime;

    public String generateToken(UserDetailsImpl user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(issuer)
                    .withIssuedAt(generateCreationDate())
                    .withExpiresAt(generateExpirationDate())
                    .withSubject(user.getUsername())
                    .sign(algorithm);
        } catch(JWTCreationException exception) {
            throw new RuntimeException("Error while generation token.", exception);
        }
    }

    public String getSubjectFromToken(String token) {
        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateCreationDate(){
        return LocalDateTime.now().toInstant(ZoneOffset.of("-03:00"));
    }
    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(Long.parseLong(expirationTime)).toInstant(ZoneOffset.of("-03:00"));
    }
}

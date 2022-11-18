package pl.paulkapela.colorchat.security.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@DependsOn({"jwtDecoder", "jwtEncoder"})
public class TokenUtil {

    @Value("${jwt.expiry}")
    private Long expiry;

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private JwtDecoder jwtDecoder;

    public String extractSubject(String token) {
        return decodeToken(token).getSubject();
    }

    public Instant extractExpiration(String token) {
        return decodeToken(token).getExpiresAt();
    }

    public String generateToken(UserDetails userDetails) {
        Instant now = Instant.now();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(userDetails.getUsername())
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractSubject(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    private Jwt decodeToken(String token) {
        return this.jwtDecoder.decode(token);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).isBefore(Instant.now());
    }
}

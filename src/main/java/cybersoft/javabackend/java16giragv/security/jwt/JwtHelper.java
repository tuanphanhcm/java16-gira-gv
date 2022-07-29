package cybersoft.javabackend.java16giragv.security.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Component
public class JwtHelper {
    private String key = "whatissecret";
    private String prefix = "Bearer ";

    public String generateJwtToken(String username) {

        Date currentDate = new Date();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(new Date(currentDate.getTime() + 86400000))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        } catch (UnsupportedJwtException e1) {
            log.error("JWT token is not supported: {}", e1);
        } catch (MalformedJwtException e2) {
            log.error("Invalid Token: {}", e2);
        } catch (SignatureException e3) {
            log.error("Invalid signature: {}", e3);
        } catch (ExpiredJwtException e4) {
            log.error("JWT is expired: {}", e4);
        } catch (IllegalArgumentException e5) {
            log.error("JWT Claims is empty: {}", e5);
        }

        return false;
    }

    public String getToken(HttpServletRequest request) {
        String jwt = request.getHeader("Authorization");

        if (jwt == null)
            return jwt;

        return jwt.substring(prefix.length(), jwt.length());
    }

    public String getUsername(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}

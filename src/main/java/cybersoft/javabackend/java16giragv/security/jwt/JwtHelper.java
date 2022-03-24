package cybersoft.javabackend.java16giragv.security.jwt;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtHelper {
	
	public String generateJwtToken(String username) {
		
		Date currentDate = new Date();
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(currentDate)
				.setExpiration(new Date(currentDate.getTime() + 86400000))
				.signWith(SignatureAlgorithm.HS512, "whatissecret")
				.compact();
	}
}

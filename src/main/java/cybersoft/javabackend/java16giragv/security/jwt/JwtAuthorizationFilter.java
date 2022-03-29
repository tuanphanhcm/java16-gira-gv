package cybersoft.javabackend.java16giragv.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtHelper helper;
	
	@Autowired
	private UserDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = helper.getToken(request);
		
		if(helper.validate(token)) {
			// get credential and set security context
			String username = helper.getUsername(token);
			UserDetails userDetails = service.loadUserByUsername(username);
			Authentication auth 
				= new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(auth);
			
			// authorization
			
		}
		filterChain.doFilter(request, response);
		
	}

}

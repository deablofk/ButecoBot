package dev.cwby.butecobot.api.security;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JwtAuthenticationFilter
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtService jwtService;

	public JwtAuthenticationFilter(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer ")) {
			String token = header.substring(7);
			try {
				Claims claims = jwtService.parseToken(token);
				String userId = claims.getSubject();

				Map<String, Object> attributes = new HashMap<>();
				attributes.put("id", userId);
				attributes.put("username", claims.get("username"));
				attributes.put("email", claims.get("email"));

				OAuth2User user = new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
						attributes, "id");

				Authentication auth = new UsernamePasswordAuthenticationToken(user, null);
				SecurityContextHolder.getContext().setAuthentication(auth);

			} catch (JwtException e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
		}

		filterChain.doFilter(request, response);
	}

}

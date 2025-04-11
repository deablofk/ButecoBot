package dev.cwby.butecobot.api.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JwtAuthenticationSuccessHandler
 */
@Component
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final JwtService jwtService;

	public JwtAuthenticationSuccessHandler(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
		String token = jwtService.generateToken(oAuth2User);

		response.setContentType("application/json");
		response.getWriter().write("{\"token\": \"" + token + "}");
	}

}

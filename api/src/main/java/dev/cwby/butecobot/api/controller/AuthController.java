package dev.cwby.butecobot.api.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthController
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@GetMapping("/success")
	public ResponseEntity<Map<String, String>> success(@AuthenticationPrincipal OAuth2User principal) {
		String discordId = principal.getAttribute("id");
		String username = principal.getAttribute("username");
		String email = principal.getAttribute("email");

		return ResponseEntity.ok(Map.of("id", discordId, "username", username, "email", email));
	}

}

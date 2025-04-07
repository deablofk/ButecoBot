package dev.cwby.butecobot.api.security;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 * JwtService
 */
@Service
public class JwtService {

	private final SecretKey secretKey;

	public JwtService(@Value("${jwt.secret}") String secret) {
		byte[] decodedKey = Base64.getDecoder().decode(secret);
		this.secretKey = Keys.hmacShaKeyFor(decodedKey);
	}

	public String generateToken(OAuth2User user) {
		var now = new Date();
		var expire = new Date(now.getTime() + 86400000);

		return Jwts.builder()
				.subject(user.getAttribute("id"))
				.claim("username", user.getAttribute("username"))
				.claim("email", user.getAttribute("email"))
				.issuedAt(now)
				.expiration(expire)
				.signWith(secretKey)
				.compact();
	}

	public Claims parseToken(String token) throws JwtException {
		return Jwts.parser().decryptWith(secretKey).build().parseSignedClaims(token).getPayload();
	}

}

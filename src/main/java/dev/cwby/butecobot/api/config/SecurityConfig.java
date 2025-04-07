package dev.cwby.butecobot.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import dev.cwby.butecobot.api.security.JwtAuthenticationFilter;
import dev.cwby.butecobot.api.security.JwtAuthenticationSuccessHandler;

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
@Profile("prod")
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtFilter;
	private final JwtAuthenticationSuccessHandler successHandler;

	public SecurityConfig(JwtAuthenticationFilter jwtFilter, JwtAuthenticationSuccessHandler successHandler) {
		this.jwtFilter = jwtFilter;
		this.successHandler = successHandler;
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(x -> x.disable())
				.cors(x -> x.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/login/**", "/oauth2/**").permitAll()
						.requestMatchers("/api/**").authenticated())
				.oauth2Login(oauth2 -> oauth2.successHandler(successHandler));

		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

}

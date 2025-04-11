package dev.cwby.butecobot.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityConfig
 */
@Configuration
@EnableWebSecurity
@Profile("dev")
public class DevSecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(x -> x.disable())
				.authorizeHttpRequests(x -> x.anyRequest().permitAll())
				.oauth2Login(x -> x.disable())
				.httpBasic(x -> x.disable())
				.formLogin(x -> x.disable());

		return http.build();
	}

}

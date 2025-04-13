package dev.cwby.butecobot.api.users.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.users.domain.User;
import dev.cwby.butecobot.api.users.mapper.UserMapper;
import dev.cwby.butecobot.api.users.service.IUserService;
import dev.cwby.butecobot.users.dto.UserRequest;
import dev.cwby.butecobot.users.dto.UserResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Endpoints for managing Discord users")
public class UserController implements IUserApi {

	private final IUserService userService;
	private static final UserMapper mapper = UserMapper.INSTANCE;

	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest user) {
		User created = userService.createUser(mapper.toEntity(user));
		return ResponseEntity.ok(mapper.toResponse(created));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
		return userService.getUserById(id).map(x -> ResponseEntity.ok(mapper.toResponse(x)))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/discord/{discordId}")
	public ResponseEntity<UserResponse> getUserByDiscordId(@PathVariable String discordId) {
		return userService.getUserByDiscordId(discordId).map(x -> ResponseEntity.ok(mapper.toResponse(x)))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserResponse> responses = mapper.toResponses(users);
		return ResponseEntity.ok(responses);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest updatedUser) {
		User user = userService.updateUser(id, mapper.toEntity(updatedUser));
		return ResponseEntity.ok(mapper.toResponse(user));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}

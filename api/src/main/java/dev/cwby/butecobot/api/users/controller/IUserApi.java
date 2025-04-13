
package dev.cwby.butecobot.api.users.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.users.dto.UserRequest;
import dev.cwby.butecobot.users.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * IUserApi
 */
public interface IUserApi {

	@Operation(summary = "Create a new User", requestBody = @RequestBody(description = "User to be created", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRequest.class))), responses = {
			@ApiResponse(responseCode = "201", description = "User created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content)
	})
	public ResponseEntity<UserResponse> createUser(UserRequest user);

	@Operation(summary = "Get User By Database ID", parameters = {
			@Parameter(name = "id", description = "Database ID of the user", required = true)
	}, responses = {
			@ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
	public ResponseEntity<UserResponse> getUserById(Long id);

	@Operation(summary = "Get User By Discord ID", parameters = {
			@Parameter(name = "discordId", description = "Discord ID of the user", required = true)
	}, responses = {
			@ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
			@ApiResponse(responseCode = "404", description = "Not found", content = @Content)
	})
	public ResponseEntity<UserResponse> getUserByDiscordId(String discordId);

	@Operation(summary = "Get All Users", responses = {
			@ApiResponse(responseCode = "200", description = "List of users", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class)))
	})
	public ResponseEntity<List<UserResponse>> getAllUsers();

	@Operation(summary = "Update User", parameters = {
			@Parameter(name = "id", description = "ID of the user to update", required = true) }, requestBody = @RequestBody(description = "Updated user data", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRequest.class))), responses = {
					@ApiResponse(responseCode = "200", description = "User updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
					@ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
	public ResponseEntity<UserResponse> updateUser(Long id, UserRequest updatedUser);

	@Operation(summary = "Delete User", parameters = {
			@Parameter(name = "id", description = "ID of the user to delete", required = true)
	}, responses = {
			@ApiResponse(responseCode = "204", description = "User deleted successfully", content = @Content),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content)
	})
	public ResponseEntity<Void> deleteUser(Long id);

}

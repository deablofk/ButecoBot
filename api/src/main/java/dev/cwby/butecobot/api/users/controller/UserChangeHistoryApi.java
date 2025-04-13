package dev.cwby.butecobot.api.users.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.cwby.butecobot.users.dto.UserChangeHistoryRequest;
import dev.cwby.butecobot.users.dto.UserChangeHistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * UserChangeHistoryController
 */
@Tag(name = "Users Changes History", description = "Endpoints for user change history")
@RequestMapping("/api/users-changes-history")
public interface UserChangeHistoryApi {

	@PostMapping
	@Operation(summary = "Save a new history record")
	ResponseEntity<UserChangeHistoryResponse> create(@RequestBody UserChangeHistoryRequest history);

	@GetMapping("/{id}")
	@Operation(summary = "Find by ID")
	ResponseEntity<UserChangeHistoryResponse> findById(@PathVariable Long id);

	@GetMapping("/user/{userId}")
	@Operation(summary = "Find history by user ID")
	ResponseEntity<List<UserChangeHistoryResponse>> findByUserId(@PathVariable Integer userId);

	@GetMapping
	@Operation(summary = "List all history records")
	ResponseEntity<List<UserChangeHistoryResponse>> findAll();

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete by ID")
	ResponseEntity<Void> deleteById(@PathVariable Long id);
}

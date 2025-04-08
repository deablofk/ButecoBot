package dev.cwby.butecobot.api.users.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.cwby.butecobot.api.users.domain.UserChangeHistory;

import java.util.List;

/**
 * UserChangeHistoryController
 */
@Tag(name = "Users Changes History", description = "Endpoints for user change history")
@RequestMapping("/api/users-changes-history")
public interface UserChangeHistoryApi {

	@PostMapping
	@Operation(summary = "Save a new history record")
	ResponseEntity<UserChangeHistory> create(@RequestBody UserChangeHistory history);

	@GetMapping("/{id}")
	@Operation(summary = "Find by ID")
	ResponseEntity<UserChangeHistory> findById(@PathVariable Long id);

	@GetMapping("/user/{userId}")
	@Operation(summary = "Find history by user ID")
	ResponseEntity<List<UserChangeHistory>> findByUserId(@PathVariable Integer userId);

	@GetMapping
	@Operation(summary = "List all history records")
	ResponseEntity<List<UserChangeHistory>> findAll();

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete by ID")
	ResponseEntity<Void> deleteById(@PathVariable Long id);
}

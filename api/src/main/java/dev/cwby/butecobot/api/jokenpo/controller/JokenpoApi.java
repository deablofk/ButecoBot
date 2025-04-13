package dev.cwby.butecobot.api.jokenpo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.users.dto.JokenpoRequest;
import dev.cwby.butecobot.users.dto.JokenpoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * JokenpoApi
 */
@Tag(name = "Jokenpo", description = "Endpoints related to Jokenpo games")
public interface JokenpoApi {

	@Operation(summary = "Create a new Jokenpo game")
	ResponseEntity<JokenpoResponse> create(JokenpoRequest jokenpo);

	@Operation(summary = "Find Jokenpo game by ID")
	ResponseEntity<JokenpoResponse> findById(Long id);

	@Operation(summary = "List all Jokenpo games")
	ResponseEntity<List<JokenpoResponse>> findAll();

	@Operation(summary = "Delete Jokenpo game by ID")
	ResponseEntity<Void> delete(Long id);
}

package dev.cwby.butecobot.api.jokenpo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.jokenpo.dto.JokenpoPlayerRequest;
import dev.cwby.butecobot.jokenpo.dto.JokenpoPlayerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * JokenpoPlayerApi
 */

@Tag(name = "JokenpoPlayer", description = "Endpoints related to Jokenpo players")
public interface JokenpoPlayerApi {

	@Operation(summary = "Create a new Jokenpo player")
	ResponseEntity<JokenpoPlayerResponse> create(JokenpoPlayerRequest player);

	@Operation(summary = "Find Jokenpo player by ID")
	ResponseEntity<JokenpoPlayerResponse> findById(Long id);

	@Operation(summary = "List all Jokenpo players")
	ResponseEntity<List<JokenpoPlayerResponse>> findAll();

	@Operation(summary = "Delete Jokenpo player by ID")
	ResponseEntity<Void> delete(Long id);
}

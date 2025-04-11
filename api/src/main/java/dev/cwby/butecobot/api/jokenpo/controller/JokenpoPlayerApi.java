package dev.cwby.butecobot.api.jokenpo.controller;

import java.util.List;

import dev.cwby.butecobot.api.jokenpo.domain.JokenpoPlayer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * JokenpoPlayerApi
 */

@Tag(name = "JokenpoPlayer", description = "Endpoints related to Jokenpo players")
public interface JokenpoPlayerApi {

	@Operation(summary = "Create a new Jokenpo player")
	JokenpoPlayer create(JokenpoPlayer player);

	@Operation(summary = "Find Jokenpo player by ID")
	JokenpoPlayer findById(Long id);

	@Operation(summary = "List all Jokenpo players")
	List<JokenpoPlayer> findAll();

	@Operation(summary = "Delete Jokenpo player by ID")
	void delete(Long id);
}

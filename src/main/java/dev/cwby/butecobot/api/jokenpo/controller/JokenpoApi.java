package dev.cwby.butecobot.api.jokenpo.controller;

import java.util.List;

import dev.cwby.butecobot.api.jokenpo.domain.Jokenpo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * JokenpoApi
 */
@Tag(name = "Jokenpo", description = "Endpoints related to Jokenpo games")
public interface JokenpoApi {

	@Operation(summary = "Create a new Jokenpo game")
	Jokenpo create(Jokenpo jokenpo);

	@Operation(summary = "Find Jokenpo game by ID")
	Jokenpo findById(Long id);

	@Operation(summary = "List all Jokenpo games")
	List<Jokenpo> findAll();

	@Operation(summary = "Delete Jokenpo game by ID")
	void delete(Long id);
}

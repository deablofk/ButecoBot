package dev.cwby.butecobot.api.roulette.controller;

import java.util.List;

import dev.cwby.butecobot.api.roulette.domain.Roulette;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * RouletteApi
 */
@Tag(name = "Roulette", description = "Endpoints related to roulettes")
public interface RouletteApi {

	@Operation(summary = "Create a new roulette")
	Roulette create(Roulette roulette);

	@Operation(summary = "Find roulette by ID")
	Roulette findById(Long id);

	@Operation(summary = "List all roulettes")
	List<Roulette> findAll();

	@Operation(summary = "Delete roulette by ID")
	void delete(Long id);
}

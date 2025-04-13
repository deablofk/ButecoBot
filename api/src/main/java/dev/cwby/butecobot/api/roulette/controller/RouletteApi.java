package dev.cwby.butecobot.api.roulette.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.api.roulette.domain.Roulette;
import dev.cwby.butecobot.users.dto.RouletteRequest;
import dev.cwby.butecobot.users.dto.RouletteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * RouletteApi
 */
@Tag(name = "Roulette", description = "Endpoints related to roulettes")
public interface RouletteApi {

	@Operation(summary = "Create a new roulette")
	ResponseEntity<RouletteResponse> create(RouletteRequest roulette);

	@Operation(summary = "Find roulette by ID")
	ResponseEntity<RouletteResponse> findById(Long id);

	@Operation(summary = "List all roulettes")
	ResponseEntity<List<RouletteResponse>> findAll();

	@Operation(summary = "Delete roulette by ID")
	ResponseEntity<Void> delete(Long id);
}

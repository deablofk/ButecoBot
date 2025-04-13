package dev.cwby.butecobot.api.roulette.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.api.roulette.domain.RouletteBet;
import dev.cwby.butecobot.users.dto.RouletteBetRequest;
import dev.cwby.butecobot.users.dto.RouletteBetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * RouletteBetApi
 */
@Tag(name = "RouletteBet", description = "Endpoints related to roulette bets")
public interface RouletteBetApi {

	@Operation(summary = "Create a new roulette bet")
	ResponseEntity<RouletteBetResponse> create(RouletteBetRequest bet);

	@Operation(summary = "Find roulette bet by ID")
	ResponseEntity<RouletteBetResponse> findById(Long id);

	@Operation(summary = "List all roulette bets")
	ResponseEntity<List<RouletteBetResponse>> findAll();

	@Operation(summary = "Delete roulette bet by ID")
	ResponseEntity<Void> delete(Long id);
}

package dev.cwby.butecobot.api.roulette.controller;

import java.util.List;

import dev.cwby.butecobot.api.roulette.domain.RouletteBet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * RouletteBetApi
 */
@Tag(name = "RouletteBet", description = "Endpoints related to roulette bets")
public interface RouletteBetApi {

	@Operation(summary = "Create a new roulette bet")
	RouletteBet create(RouletteBet bet);

	@Operation(summary = "Find roulette bet by ID")
	RouletteBet findById(Long id);

	@Operation(summary = "List all roulette bets")
	List<RouletteBet> findAll();

	@Operation(summary = "Delete roulette bet by ID")
	void delete(Long id);
}

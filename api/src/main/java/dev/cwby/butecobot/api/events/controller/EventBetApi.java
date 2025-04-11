package dev.cwby.butecobot.api.events.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import dev.cwby.butecobot.api.events.domain.EventBet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * EventBetApi
 */
@Tag(name = "Event Bets", description = "Endpoints for the Event Bets")
@RequestMapping("/api/events")
public interface EventBetApi {

	@Operation(summary = "Create a bet")
	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "Bet created successfully")
	})
	EventBet createBet(EventBet bet);

	@Operation(summary = "Update a bet")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Bet updated successfully")
	})
	EventBet updateBet(Long id, EventBet bet);

	@Operation(summary = "Delete a bet")
	@ApiResponses({
			@ApiResponse(responseCode = "204", description = "Bet deleted successfully")
	})
	void deleteBet(Long id);

	@Operation(summary = "Get bet by ID")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Bet retrieved successfully")
	})
	EventBet getBetById(Long id);
}

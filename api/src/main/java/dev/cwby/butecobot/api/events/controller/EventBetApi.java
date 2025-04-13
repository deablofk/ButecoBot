package dev.cwby.butecobot.api.events.controller;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.events.dto.EventBetRequest;
import dev.cwby.butecobot.events.dto.EventBetResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * EventBetApi
 */
@Tag(name = "Event Bets", description = "Endpoints for the Event Bets")
public interface EventBetApi {

	@Operation(summary = "Create a bet")
	@ApiResponse(responseCode = "201", description = "Bet created successfully")
	ResponseEntity<EventBetResponse> createBet(EventBetRequest bet);

	@Operation(summary = "Update a bet")
	@ApiResponse(responseCode = "200", description = "Bet updated successfully")
	ResponseEntity<EventBetResponse> updateBet(Long id, EventBetRequest bet);

	@Operation(summary = "Delete a bet")
	@ApiResponse(responseCode = "204", description = "Bet deleted successfully")
	ResponseEntity<Void> deleteBet(Long id);

	@Operation(summary = "Get bet by ID")
	@ApiResponse(responseCode = "200", description = "Bet retrieved successfully")
	ResponseEntity<EventBetResponse> getBetById(Long id);
}

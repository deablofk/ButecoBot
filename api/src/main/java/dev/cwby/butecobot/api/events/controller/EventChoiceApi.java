package dev.cwby.butecobot.api.events.controller;

import dev.cwby.butecobot.api.events.domain.EventChoice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * EventChoiceApi
 */

@Tag(name = "Event Choices", description = "Endpoints for the Event Choices")
public interface EventChoiceApi {

	@Operation(summary = "Create an event choice")
	@ApiResponses({
			@ApiResponse(responseCode = "201", description = "Choice created successfully")
	})
	EventChoice createChoice(EventChoice choice);

	@Operation(summary = "Update an event choice")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Choice updated successfully")
	})
	EventChoice updateChoice(Long id, EventChoice choice);

	@Operation(summary = "Delete an event choice")
	@ApiResponses({
			@ApiResponse(responseCode = "204", description = "Choice deleted successfully")
	})
	void deleteChoice(Long id);

	@Operation(summary = "Get a choice by ID")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "Choice retrieved successfully")
	})
	EventChoice getChoiceById(Long id);
}

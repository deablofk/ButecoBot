package dev.cwby.butecobot.api.events.controller;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.events.dto.EventChoiceRequest;
import dev.cwby.butecobot.events.dto.EventChoiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * EventChoiceApi
 */

@Tag(name = "Event Choices", description = "Endpoints for the Event Choices")
public interface EventChoiceApi {

	@Operation(summary = "Create an event choice")
	@ApiResponse(responseCode = "201", description = "Choice created successfully")
	ResponseEntity<EventChoiceResponse> createChoice(EventChoiceRequest choice);

	@Operation(summary = "Update an event choice")
	@ApiResponse(responseCode = "200", description = "Choice updated successfully")
	ResponseEntity<EventChoiceResponse> updateChoice(Long id, EventChoiceRequest choice);

	@Operation(summary = "Delete an event choice")
	@ApiResponse(responseCode = "204", description = "Choice deleted successfully")
	ResponseEntity<Void> deleteChoice(Long id);

	@Operation(summary = "Get a choice by ID")
	@ApiResponse(responseCode = "200", description = "Choice retrieved successfully")
	ResponseEntity<EventChoiceResponse> getChoiceById(Long id);
}

package dev.cwby.butecobot.api.events.controller;

import org.springframework.http.ResponseEntity;

import dev.cwby.butecobot.events.dto.EventRequest;
import dev.cwby.butecobot.events.dto.EventResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * EventControllerApi
 */
@Tag(name = "Events", description = "Endpoints for the Events")
public interface EventControllerApi {

	@Operation(summary = "Create an event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Event created successfully")
	})
	ResponseEntity<EventResponse> createEvent(EventRequest event);

	@Operation(summary = "Update an event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Event updated successfully")
	})
	ResponseEntity<EventResponse> updateEvent(Long id, EventRequest event);

	@Operation(summary = "Delete an event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Event deleted successfully")
	})
	ResponseEntity<Void> deleteEvent(Long id);

	@Operation(summary = "Get an event by ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Event retrieved successfully")
	})
	ResponseEntity<EventResponse> getEventById(Long id);

}

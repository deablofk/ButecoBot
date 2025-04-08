package dev.cwby.butecobot.api.events.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import dev.cwby.butecobot.api.events.domain.Event;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * EventControllerApi
 */
@Tag(name = "Events", description = "Endpoints for the Events")
@RequestMapping("/api/events")
public interface EventControllerApi {

	@Operation(summary = "Create an event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Event created successfully")
	})
	Event createEvent(Event event);

	@Operation(summary = "Update an event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Event updated successfully")
	})
	Event updateEvent(Long id, Event event);

	@Operation(summary = "Delete an event")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Event deleted successfully")
	})
	void deleteEvent(Long id);

	@Operation(summary = "Get an event by ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Event retrieved successfully")
	})
	Event getEventById(Long id);

}

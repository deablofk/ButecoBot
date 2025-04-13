package dev.cwby.butecobot.api.events.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.events.mapper.EventMapper;
import dev.cwby.butecobot.api.events.service.IEventService;
import dev.cwby.butecobot.events.dto.EventRequest;
import dev.cwby.butecobot.events.dto.EventResponse;
import lombok.AllArgsConstructor;

/**
 * EventController
 */
@RestController
@RequestMapping("/api/events")
@AllArgsConstructor
public class EventController implements EventControllerApi {

	private IEventService service;
	private static final EventMapper mapper = EventMapper.INSTANCE;

	@Override
	@PostMapping
	public ResponseEntity<EventResponse> createEvent(@RequestBody EventRequest event) {
		return ResponseEntity.ok(mapper.toResponse(service.createEvent(mapper.toEntity(event))));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<EventResponse> updateEvent(@PathVariable Long id, @RequestBody EventRequest event) {
		return ResponseEntity.ok(mapper.toResponse(service.updateEvent(id, mapper.toEntity(event))));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
		service.deleteEvent(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<EventResponse> getEventById(@PathVariable Long id) {
		return ResponseEntity.ok(mapper.toResponse(service.getEventById(id)));
	}
}

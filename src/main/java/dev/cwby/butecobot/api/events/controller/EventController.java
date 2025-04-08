package dev.cwby.butecobot.api.events.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.events.domain.Event;
import dev.cwby.butecobot.api.events.service.IEventService;
import lombok.AllArgsConstructor;

/**
 * EventController
 */
@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController implements EventControllerApi {

	private IEventService service;

	@Override
	@PostMapping
	public Event createEvent(@RequestBody Event event) {
		return service.createEvent(event);
	}

	@Override
	@PutMapping("/{id}")
	public Event updateEvent(@PathVariable Long id, @RequestBody Event event) {
		return service.updateEvent(id, event);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable Long id) {
		service.deleteEvent(id);
	}

	@Override
	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id) {
		return service.getEventById(id);
	}
}

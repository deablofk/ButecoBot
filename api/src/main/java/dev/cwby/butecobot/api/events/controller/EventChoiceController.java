package dev.cwby.butecobot.api.events.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.events.domain.EventChoice;
import dev.cwby.butecobot.api.events.service.IEventChoiceService;
import lombok.AllArgsConstructor;

/**
 * EventChoiceContreller
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/choices")
public class EventChoiceController implements EventChoiceApi {

	private IEventChoiceService service;

	@Override
	@PostMapping
	public EventChoice createChoice(@RequestBody EventChoice choice) {
		return service.createChoice(choice);
	}

	@Override
	@PutMapping("/{id}")
	public EventChoice updateChoice(@PathVariable Long id, @RequestBody EventChoice choice) {
		return service.updateChoice(id, choice);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteChoice(@PathVariable Long id) {
		service.deleteChoice(id);
	}

	@Override
	@GetMapping("/{id}")
	public EventChoice getChoiceById(@PathVariable Long id) {
		return service.getChoiceById(id);
	}
}

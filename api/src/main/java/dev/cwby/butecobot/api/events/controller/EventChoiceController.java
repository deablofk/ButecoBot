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

import dev.cwby.butecobot.api.events.mapper.EventChoiceMapper;
import dev.cwby.butecobot.api.events.service.IEventChoiceService;
import dev.cwby.butecobot.events.dto.EventChoiceRequest;
import dev.cwby.butecobot.events.dto.EventChoiceResponse;
import lombok.AllArgsConstructor;

/**
 * EventChoiceContreller
 */

@RestController
@AllArgsConstructor
@RequestMapping("/api/choices")
public class EventChoiceController implements EventChoiceApi {

	private IEventChoiceService service;
	private static final EventChoiceMapper mapper = EventChoiceMapper.INSTANCE;

	@Override
	@PostMapping
	public ResponseEntity<EventChoiceResponse> createChoice(@RequestBody EventChoiceRequest choice) {
		return ResponseEntity.ok(mapper.toResponse(service.createChoice(mapper.toEntity(choice))));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<EventChoiceResponse> updateChoice(@PathVariable Long id,
			@RequestBody EventChoiceRequest choice) {
		return ResponseEntity.ok(mapper.toResponse(service.updateChoice(id, mapper.toEntity(choice))));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteChoice(@PathVariable Long id) {
		service.deleteChoice(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<EventChoiceResponse> getChoiceById(@PathVariable Long id) {
		return ResponseEntity.ok(mapper.toResponse(service.getChoiceById(id)));
	}
}

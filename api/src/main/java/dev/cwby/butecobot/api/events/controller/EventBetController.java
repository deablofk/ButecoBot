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

import dev.cwby.butecobot.api.events.mapper.EventBetMapper;
import dev.cwby.butecobot.api.events.service.IEventBetService;
import dev.cwby.butecobot.events.dto.EventBetRequest;
import dev.cwby.butecobot.events.dto.EventBetResponse;
import lombok.AllArgsConstructor;

/**
 * EventBetController
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/bets")
public class EventBetController implements EventBetApi {

	private IEventBetService eventBetService;
	private static final EventBetMapper mapper = EventBetMapper.INSTANCE;

	@Override
	@PostMapping
	public ResponseEntity<EventBetResponse> createBet(@RequestBody EventBetRequest bet) {
		return ResponseEntity.ok(mapper.toResponse(eventBetService.createBet(mapper.toEntity(bet))));
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<EventBetResponse> updateBet(@PathVariable Long id, @RequestBody EventBetRequest bet) {
		return ResponseEntity.ok(mapper.toResponse(eventBetService.updateBet(id, mapper.toEntity(bet))));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBet(@PathVariable Long id) {
		eventBetService.deleteBet(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<EventBetResponse> getBetById(@PathVariable Long id) {
		return ResponseEntity.ok(mapper.toResponse(eventBetService.getBetById(id)));
	}
}

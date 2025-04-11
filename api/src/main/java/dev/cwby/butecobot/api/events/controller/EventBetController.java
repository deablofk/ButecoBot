package dev.cwby.butecobot.api.events.controller;

import org.springframework.web.bind.annotation.*;

import dev.cwby.butecobot.api.events.domain.EventBet;
import dev.cwby.butecobot.api.events.service.IEventBetService;
import lombok.AllArgsConstructor;

/**
 * EventBetController
 */
@RestController
@AllArgsConstructor
@RequestMapping("/bets")
public class EventBetController implements EventBetApi {

	private IEventBetService eventBetService;

	@Override
	@PostMapping
	public EventBet createBet(@RequestBody EventBet bet) {
		return eventBetService.createBet(bet);
	}

	@Override
	@PutMapping("/{id}")
	public EventBet updateBet(@PathVariable Long id, @RequestBody EventBet bet) {
		return eventBetService.updateBet(id, bet);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deleteBet(@PathVariable Long id) {
		eventBetService.deleteBet(id);
	}

	@Override
	@GetMapping("/{id}")
	public EventBet getBetById(@PathVariable Long id) {
		return eventBetService.getBetById(id);
	}
}

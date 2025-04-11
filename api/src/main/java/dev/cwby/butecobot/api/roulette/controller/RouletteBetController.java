package dev.cwby.butecobot.api.roulette.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.roulette.domain.RouletteBet;
import dev.cwby.butecobot.api.roulette.service.IRouletteBetService;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * RouletteBetController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roulette-bet")
public class RouletteBetController implements RouletteBetApi {

	private final IRouletteBetService service;

	@Override
	@PostMapping
	public RouletteBet create(@RequestBody RouletteBet bet) {
		return service.save(bet);
	}

	@Override
	@GetMapping("/{id}")
	public RouletteBet findById(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new RuntimeException("Roulette bet not found"));
	}

	@Override
	@GetMapping
	public List<RouletteBet> findAll() {
		return service.findAll();
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}

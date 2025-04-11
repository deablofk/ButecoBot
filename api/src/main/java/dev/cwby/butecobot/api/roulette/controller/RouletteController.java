package dev.cwby.butecobot.api.roulette.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.roulette.domain.Roulette;
import dev.cwby.butecobot.api.roulette.service.IRouletteService;
import lombok.RequiredArgsConstructor;

/**
 * RouletteController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roulette")
public class RouletteController implements RouletteApi {

	private final IRouletteService service;

	@Override
	@PostMapping
	public Roulette create(@RequestBody Roulette roulette) {
		return service.save(roulette);
	}

	@Override
	@GetMapping("/{id}")
	public Roulette findById(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new RuntimeException("Roulette not found"));
	}

	@Override
	@GetMapping
	public List<Roulette> findAll() {
		return service.findAll();
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}

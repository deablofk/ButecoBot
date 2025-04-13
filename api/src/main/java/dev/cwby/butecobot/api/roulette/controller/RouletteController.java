package dev.cwby.butecobot.api.roulette.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.roulette.mapper.RouletteMapper;
import dev.cwby.butecobot.api.roulette.service.IRouletteService;
import dev.cwby.butecobot.users.dto.RouletteRequest;
import dev.cwby.butecobot.users.dto.RouletteResponse;
import lombok.RequiredArgsConstructor;

/**
 * RouletteController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roulette")
public class RouletteController implements RouletteApi {

	private final IRouletteService service;
	private static final RouletteMapper mapper = RouletteMapper.INSTANCE;

	@Override
	@PostMapping
	public ResponseEntity<RouletteResponse> create(@RequestBody RouletteRequest roulette) {
		return ResponseEntity.ok(mapper.toResponse(service.save(mapper.toEntity(roulette))));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<RouletteResponse> findById(@PathVariable Long id) {
		return service.findById(id).map(x -> ResponseEntity.ok(mapper.toResponse(x)))
				.orElseThrow(() -> new RuntimeException("Roulette not found"));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<RouletteResponse>> findAll() {
		return ResponseEntity.ok(mapper.toResponses(service.findAll()));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

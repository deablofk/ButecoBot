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

import dev.cwby.butecobot.api.roulette.mapper.RouletteBetMapper;
import dev.cwby.butecobot.api.roulette.service.IRouletteBetService;
import dev.cwby.butecobot.roulette.dto.RouletteBetRequest;
import dev.cwby.butecobot.roulette.dto.RouletteBetResponse;
import lombok.RequiredArgsConstructor;

/**
 * RouletteBetController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/roulette-bet")
public class RouletteBetController implements RouletteBetApi {

	private final IRouletteBetService service;
	private static final RouletteBetMapper mapper = RouletteBetMapper.INSTANCE;

	@Override
	@PostMapping
	public ResponseEntity<RouletteBetResponse> create(@RequestBody RouletteBetRequest bet) {
		return ResponseEntity.ok(mapper.toResponse(service.save(mapper.toEntity(bet))));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<RouletteBetResponse> findById(@PathVariable Long id) {
		return service.findById(id).map(x -> ResponseEntity.ok(mapper.toResponse(x)))
				.orElseThrow(() -> new RuntimeException("Roulette bet not found"));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<RouletteBetResponse>> findAll() {
		return ResponseEntity.ok(mapper.toResponses(service.findAll()));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

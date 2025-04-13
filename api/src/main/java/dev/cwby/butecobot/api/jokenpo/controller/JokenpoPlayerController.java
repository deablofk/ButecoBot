package dev.cwby.butecobot.api.jokenpo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.jokenpo.mapper.JokenpoPlayerMapper;
import dev.cwby.butecobot.api.jokenpo.service.IJokenpoPlayerService;
import dev.cwby.butecobot.jokenpo.dto.JokenpoPlayerRequest;
import dev.cwby.butecobot.jokenpo.dto.JokenpoPlayerResponse;
import lombok.RequiredArgsConstructor;

/**
 * JokenpoPlayerController
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jokenpo-players")
public class JokenpoPlayerController implements JokenpoPlayerApi {

	private final IJokenpoPlayerService service;
	private static final JokenpoPlayerMapper mapper = JokenpoPlayerMapper.INSTANCE;

	@Override
	@PostMapping
	public ResponseEntity<JokenpoPlayerResponse> create(@RequestBody JokenpoPlayerRequest player) {
		return ResponseEntity.ok(mapper.toResponse(service.save(mapper.toEntity(player))));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<JokenpoPlayerResponse> findById(@PathVariable Long id) {
		return service.findById(id).map(x -> ResponseEntity.ok(mapper.toResponse(x)))
				.orElseThrow(() -> new RuntimeException("Jokenpo player not found"));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<JokenpoPlayerResponse>> findAll() {
		return ResponseEntity.ok(mapper.toResponses(service.findAll()));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

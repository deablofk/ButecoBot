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

import dev.cwby.butecobot.api.jokenpo.mapper.JokenpoMapper;
import dev.cwby.butecobot.api.jokenpo.service.IJokenpoService;
import dev.cwby.butecobot.users.dto.JokenpoRequest;
import dev.cwby.butecobot.users.dto.JokenpoResponse;
import lombok.RequiredArgsConstructor;

/**
 * JokenpoController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jokenpo")
public class JokenpoController implements JokenpoApi {

	private final IJokenpoService service;
	private static final JokenpoMapper mapper = JokenpoMapper.INSTANCE;

	@Override
	@PostMapping
	public ResponseEntity<JokenpoResponse> create(@RequestBody JokenpoRequest jokenpo) {
		return ResponseEntity.ok(mapper.toResponse(service.save(mapper.toEntity(jokenpo))));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<JokenpoResponse> findById(@PathVariable Long id) {
		return service.findById(id).map(x -> ResponseEntity.ok(mapper.toResponse(x)))
				.orElseThrow(() -> new RuntimeException("Jokenpo game not found"));
	}

	@Override
	@GetMapping
	public ResponseEntity<List<JokenpoResponse>> findAll() {
		return ResponseEntity.ok(mapper.toResponses(service.findAll()));
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

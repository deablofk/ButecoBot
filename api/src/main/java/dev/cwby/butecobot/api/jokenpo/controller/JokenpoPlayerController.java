package dev.cwby.butecobot.api.jokenpo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.jokenpo.domain.JokenpoPlayer;
import dev.cwby.butecobot.api.jokenpo.service.IJokenpoPlayerService;
import lombok.RequiredArgsConstructor;

/**
 * JokenpoPlayerController
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jokenpo-players")
public class JokenpoPlayerController implements JokenpoPlayerApi {

	private final IJokenpoPlayerService service;

	@Override
	@PostMapping
	public JokenpoPlayer create(@RequestBody JokenpoPlayer player) {
		return service.save(player);
	}

	@Override
	@GetMapping("/{id}")
	public JokenpoPlayer findById(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new RuntimeException("Jokenpo player not found"));
	}

	@Override
	@GetMapping
	public List<JokenpoPlayer> findAll() {
		return service.findAll();
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}

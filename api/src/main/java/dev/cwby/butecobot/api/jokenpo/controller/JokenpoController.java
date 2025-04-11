package dev.cwby.butecobot.api.jokenpo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.jokenpo.domain.Jokenpo;
import dev.cwby.butecobot.api.jokenpo.service.IJokenpoService;
import lombok.RequiredArgsConstructor;

/**
 * JokenpoController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/jokenpo")
public class JokenpoController implements JokenpoApi {

	private final IJokenpoService service;

	@Override
	@PostMapping
	public Jokenpo create(@RequestBody Jokenpo jokenpo) {
		return service.save(jokenpo);
	}

	@Override
	@GetMapping("/{id}")
	public Jokenpo findById(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new RuntimeException("Jokenpo game not found"));
	}

	@Override
	@GetMapping
	public List<Jokenpo> findAll() {
		return service.findAll();
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}

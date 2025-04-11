package dev.cwby.butecobot.api.jokenpo.service;

import java.util.List;
import java.util.Optional;

import dev.cwby.butecobot.api.jokenpo.domain.Jokenpo;

/**
 * IJokenpoService
 */
public interface IJokenpoService {
	Jokenpo save(Jokenpo jokenpo);

	Optional<Jokenpo> findById(Long id);

	List<Jokenpo> findAll();

	void deleteById(Long id);
}

package dev.cwby.butecobot.api.jokenpo.service;

import java.util.List;
import java.util.Optional;

import dev.cwby.butecobot.api.jokenpo.domain.JokenpoPlayer;

/**
 * IJokenpoPlayerService
 */
public interface IJokenpoPlayerService {
	JokenpoPlayer save(JokenpoPlayer player);

	Optional<JokenpoPlayer> findById(Long id);

	List<JokenpoPlayer> findAll();

	void deleteById(Long id);
}

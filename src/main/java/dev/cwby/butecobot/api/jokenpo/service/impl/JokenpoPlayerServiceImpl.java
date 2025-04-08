package dev.cwby.butecobot.api.jokenpo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.jokenpo.domain.JokenpoPlayer;
import dev.cwby.butecobot.api.jokenpo.repository.JokenpoPlayerRepository;
import dev.cwby.butecobot.api.jokenpo.service.IJokenpoPlayerService;
import lombok.RequiredArgsConstructor;

/**
 * JokenpoPlayerServiceImpl
 */
@Service
@RequiredArgsConstructor
public class JokenpoPlayerServiceImpl implements IJokenpoPlayerService {

	private final JokenpoPlayerRepository repository;

	@Override
	public JokenpoPlayer save(JokenpoPlayer player) {
		return repository.save(player);
	}

	@Override
	public Optional<JokenpoPlayer> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<JokenpoPlayer> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

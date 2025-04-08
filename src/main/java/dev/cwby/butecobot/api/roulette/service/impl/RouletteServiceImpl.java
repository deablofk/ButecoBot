package dev.cwby.butecobot.api.roulette.service.impl;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.roulette.domain.Roulette;
import dev.cwby.butecobot.api.roulette.repository.RouletteRepository;

import java.util.List;
import java.util.Optional;

/**
 * RouletteServiceImpl
 */
@Service
public class RouletteServiceImpl implements IRouletteService {

	private final RouletteRepository repository;

	public RouletteServiceImpl(RouletteRepository repository) {
		this.repository = repository;
	}

	@Override
	public Roulette save(Roulette roulette) {
		return repository.save(roulette);
	}

	@Override
	public Optional<Roulette> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Roulette> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

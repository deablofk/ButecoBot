package dev.cwby.butecobot.api.roulette.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.roulette.domain.RouletteBet;
import dev.cwby.butecobot.api.roulette.repository.RouletteBetRepository;
import dev.cwby.butecobot.api.roulette.service.IRouletteBetService;

/**
 * RouletteBetServiceImpl
 */
@Service
public class RouletteBetServiceImpl implements IRouletteBetService {

	private final RouletteBetRepository repository;

	public RouletteBetServiceImpl(RouletteBetRepository repository) {
		this.repository = repository;
	}

	@Override
	public RouletteBet save(RouletteBet bet) {
		return repository.save(bet);
	}

	@Override
	public Optional<RouletteBet> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<RouletteBet> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

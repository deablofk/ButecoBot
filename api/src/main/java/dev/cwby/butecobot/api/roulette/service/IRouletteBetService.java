package dev.cwby.butecobot.api.roulette.service;

import java.util.List;
import java.util.Optional;

import dev.cwby.butecobot.api.roulette.domain.RouletteBet;

/**
 * IRouletteBetService
 */
public interface IRouletteBetService {
	RouletteBet save(RouletteBet bet);

	Optional<RouletteBet> findById(Long id);

	List<RouletteBet> findAll();

	void deleteById(Long id);
}

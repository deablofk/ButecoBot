package dev.cwby.butecobot.api.roulette.service;

import java.util.List;
import java.util.Optional;

import dev.cwby.butecobot.api.roulette.domain.Roulette;

/**
 * IRouletteService
 */
public interface IRouletteService {
	Roulette save(Roulette roulette);

	Optional<Roulette> findById(Long id);

	List<Roulette> findAll();

	void deleteById(Long id);
}

package dev.cwby.butecobot.api.roulette.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.cwby.butecobot.api.roulette.domain.RouletteBet;

/**
 * RouletteBetRepository
 */
@Repository
public interface RouletteBetRepository extends JpaRepository<RouletteBet, Long> {
}

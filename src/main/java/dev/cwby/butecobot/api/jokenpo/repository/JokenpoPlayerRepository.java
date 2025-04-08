package dev.cwby.butecobot.api.jokenpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.cwby.butecobot.api.jokenpo.domain.JokenpoPlayer;

/**
 * JokenpoPlayerRepository
 */
@Repository
public interface JokenpoPlayerRepository extends JpaRepository<JokenpoPlayer, Long> {
}

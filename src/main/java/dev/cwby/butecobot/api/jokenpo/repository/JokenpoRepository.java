package dev.cwby.butecobot.api.jokenpo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.cwby.butecobot.api.jokenpo.domain.Jokenpo;

/**
 * JokenpoRepository
 */
@Repository
public interface JokenpoRepository extends JpaRepository<Jokenpo, Long> {
}

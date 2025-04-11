package dev.cwby.butecobot.api.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.cwby.butecobot.api.events.domain.EventBet;

/**
 * EventBetRepository
 */
@Repository
public interface EventBetRepository extends JpaRepository<EventBet, Long> {
}

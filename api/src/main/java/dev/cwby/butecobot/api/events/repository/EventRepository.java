package dev.cwby.butecobot.api.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cwby.butecobot.api.events.domain.Event;

/**
 * EventRepository
 */
public interface EventRepository extends JpaRepository<Event, Long> {

}

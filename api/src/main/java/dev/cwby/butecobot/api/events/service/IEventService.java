package dev.cwby.butecobot.api.events.service;

import dev.cwby.butecobot.api.events.domain.Event;

/**
 * IEventService
 */
public interface IEventService {

	Event createEvent(Event event);

	Event updateEvent(Long id, Event event);

	void deleteEvent(Long id);

	Event getEventById(Long id);
}

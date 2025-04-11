package dev.cwby.butecobot.api.events.service;

import dev.cwby.butecobot.api.events.domain.EventChoice;

/**
 * IEventChoiceService
 */
public interface IEventChoiceService {
	EventChoice createChoice(EventChoice choice);

	EventChoice updateChoice(Long id, EventChoice choice);

	void deleteChoice(Long id);

	EventChoice getChoiceById(Long id);
}

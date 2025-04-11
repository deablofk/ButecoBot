package dev.cwby.butecobot.api.events.service.impl;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.events.domain.EventChoice;
import dev.cwby.butecobot.api.events.repository.EventChoiceRepository;
import dev.cwby.butecobot.api.events.service.IEventChoiceService;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * EventChoiceService
 */
@Service
@AllArgsConstructor
public class EventChoiceServiceImpl implements IEventChoiceService {

	private EventChoiceRepository repository;

	@Override
	public EventChoice createChoice(EventChoice choice) {
		choice.setCreatedAt(LocalDateTime.now());
		choice.setUpdatedAt(LocalDateTime.now());
		return repository.save(choice);
	}

	@Override
	public EventChoice updateChoice(Long id, EventChoice choice) {
		EventChoice existing = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Choice not found"));
		existing.setChoice(choice.getChoice());
		existing.setDescription(choice.getDescription());
		existing.setUpdatedAt(LocalDateTime.now());
		return repository.save(existing);
	}

	@Override
	public void deleteChoice(Long id) {
		repository.deleteById(id);
	}

	@Override
	public EventChoice getChoiceById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Choice not found"));
	}
}

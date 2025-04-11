package dev.cwby.butecobot.api.events.service.impl;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.events.domain.EventBet;
import dev.cwby.butecobot.api.events.repository.EventBetRepository;
import dev.cwby.butecobot.api.events.service.IEventBetService;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * EventBetServiceImpl
 */
@Service
@AllArgsConstructor
public class EventBetServiceImpl implements IEventBetService {

	private EventBetRepository eventBetRepository;

	@Override
	public EventBet createBet(EventBet bet) {
		bet.setCreatedAt(LocalDateTime.now());
		bet.setUpdatedAt(LocalDateTime.now());
		return eventBetRepository.save(bet);
	}

	@Override
	public EventBet updateBet(Long id, EventBet bet) {
		EventBet existingBet = eventBetRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Bet not found"));
		existingBet.setAmount(bet.getAmount());
		existingBet.setChoiceId(bet.getChoiceId());
		existingBet.setUpdatedAt(LocalDateTime.now());
		return eventBetRepository.save(existingBet);
	}

	@Override
	public void deleteBet(Long id) {
		eventBetRepository.deleteById(id);
	}

	@Override
	public EventBet getBetById(Long id) {
		return eventBetRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Bet not found"));
	}
}

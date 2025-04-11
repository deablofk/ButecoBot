package dev.cwby.butecobot.api.events.service;

import dev.cwby.butecobot.api.events.domain.EventBet;

/**
 * IEventBetService
 */
public interface IEventBetService {

	EventBet createBet(EventBet bet);

	EventBet updateBet(Long id, EventBet bet);

	void deleteBet(Long id);

	EventBet getBetById(Long id);

}

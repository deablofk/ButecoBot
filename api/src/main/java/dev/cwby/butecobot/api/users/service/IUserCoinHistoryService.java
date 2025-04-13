package dev.cwby.butecobot.api.users.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import dev.cwby.butecobot.api.users.domain.UserCoinHistory;

/**
 * IUserCoinHistory
 */
public interface IUserCoinHistoryService {
	UserCoinHistory save(UserCoinHistory history);

	Optional<UserCoinHistory> findById(Long id);

	List<UserCoinHistory> findAll();

	void deleteById(Long id);

	BigDecimal findTotalCoinsByDiscordId(String discordId);
}

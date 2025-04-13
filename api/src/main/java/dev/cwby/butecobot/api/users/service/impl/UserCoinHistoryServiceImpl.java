package dev.cwby.butecobot.api.users.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.common.exception.ApiException;
import dev.cwby.butecobot.api.common.exception.ErrorCode;
import dev.cwby.butecobot.api.users.domain.UserCoinHistory;
import dev.cwby.butecobot.api.users.repository.UserCoinHistoryRepository;
import dev.cwby.butecobot.api.users.service.IUserCoinHistoryService;
import lombok.RequiredArgsConstructor;

/**
 * UserCoinHistoryImpl
 */
@Service
@RequiredArgsConstructor
public class UserCoinHistoryServiceImpl implements IUserCoinHistoryService {

	private final UserCoinHistoryRepository repository;

	@Override
	public UserCoinHistory save(UserCoinHistory history) {
		return repository.save(history);
	}

	@Override
	public Optional<UserCoinHistory> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<UserCoinHistory> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public BigDecimal findTotalCoinsByDiscordId(String discordId) {
		return repository.findTotalCoinsByDiscordId(discordId)
				.orElseThrow(() -> new ApiException(ErrorCode.DISCORD_USER_NOT_FOUND));
	}

}

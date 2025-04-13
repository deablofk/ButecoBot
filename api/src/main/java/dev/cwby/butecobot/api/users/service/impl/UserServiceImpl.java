package dev.cwby.butecobot.api.users.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.common.exception.ApiException;
import dev.cwby.butecobot.api.common.exception.ErrorCode;
import dev.cwby.butecobot.api.users.domain.User;
import dev.cwby.butecobot.api.users.repository.UserCoinHistoryRepository;
import dev.cwby.butecobot.api.users.repository.UserRepository;
import dev.cwby.butecobot.api.users.service.IUserService;
import lombok.RequiredArgsConstructor;

/**
 * UserServiceImpl
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

	private final UserRepository userRepository;
	private final UserCoinHistoryRepository coinHistoryRepository;

	@Override
	public User createUser(User user) {
		if (userRepository.existsByDiscordId(user.getDiscordId())) {
			throw new ApiException(ErrorCode.DISCORD_USER_ALREADY_EXISTS);
		}
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> getUserByDiscordId(String discordId) {
		return userRepository.findByDiscordId(discordId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User updatedUser) {
		var existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.DISCORD_USER_NOT_FOUND));

		existingUser.setUsername(updatedUser.getUsername());
		existingUser.setNickname(updatedUser.getNickname());
		existingUser.setAvatar(updatedUser.getAvatar());
		existingUser.setReceivedInitialCoins(updatedUser.isReceivedInitialCoins());
		existingUser.setAdmin(updatedUser.isAdmin());
		existingUser.setUpdatedAt(LocalDateTime.now());

		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser(Long id) {
		User existingUser = userRepository.findById(id)
				.orElseThrow(() -> new ApiException(ErrorCode.DISCORD_USER_NOT_FOUND));
		userRepository.deleteById(existingUser.getId());
	}

	@Override
	public User getUserByDiscordIdWithTotalCoins(String discordId) {
		User user = userRepository.findByDiscordId(discordId)
				.orElseThrow(() -> new ApiException(ErrorCode.DISCORD_USER_NOT_FOUND));
		BigDecimal totalCoins = coinHistoryRepository.findTotalCoinsByDiscordId(discordId).get();
		user.setTotalCoins(totalCoins);

		boolean canReceiveDailyCoins = coinHistoryRepository.findTodayDailyHistoryByDiscordId(discordId).isEmpty();
		user.setCanReceiveDailyCoins(canReceiveDailyCoins);

		return user;
	}

}

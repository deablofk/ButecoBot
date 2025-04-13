package dev.cwby.butecobot.api.users.service;

import java.util.List;
import java.util.Optional;

import dev.cwby.butecobot.api.users.domain.User;

/**
 * IUserService
 */
public interface IUserService {

	User createUser(User user);

	Optional<User> getUserById(Long id);

	Optional<User> getUserByDiscordId(String discordId);

	User getUserByDiscordIdWithTotalCoins(String discordId);

	List<User> getAllUsers();

	User updateUser(Long id, User updatedUser);

	void deleteUser(Long id);

}

package dev.cwby.butecobot.api.users;

import java.util.List;
import java.util.Optional;

/**
 * IUserService
 */
public interface IUserService {

	User createUser(User user);

	Optional<User> getUserById(Long id);

	Optional<User> getUserByDiscordId(String discordId);

	List<User> getAllUsers();

	User updateUser(Long id, User updatedUser);

	void deleteUser(Long id);

}

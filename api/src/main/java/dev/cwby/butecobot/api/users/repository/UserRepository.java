package dev.cwby.butecobot.api.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.cwby.butecobot.api.users.domain.User;

import java.util.Optional;

/**
 * UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByDiscordId(String discordId);

	Optional<User> findByUsername(String username);

	boolean existsByDiscordId(String discordId);

}

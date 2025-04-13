package dev.cwby.butecobot.api.users.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.cwby.butecobot.api.users.domain.UserCoinHistory;

/**
 * UserCoinHistoryRepository
 */
@Repository
public interface UserCoinHistoryRepository extends JpaRepository<UserCoinHistory, Long> {

	@Query(value = """
	SELECT SUM(uch.amount)
	FROM users_coins_history uch
	JOIN users u ON uch.user_id = u.id
	WHERE u.discord_id = :discordId
	""", nativeQuery = true)
	Optional<BigDecimal> findTotalCoinsByDiscordId(@Param("discordId") String discordId);
}

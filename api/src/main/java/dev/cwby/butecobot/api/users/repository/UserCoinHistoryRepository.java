package dev.cwby.butecobot.api.users.repository;

import java.math.BigDecimal;
import java.util.List;
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

	@Query(value = """
			SELECT uch.*
			FROM users_coins_history uch
			JOIN users u ON uch.user_id = u.id
			WHERE u.discord_id = :discordId
			AND uch.type = 'Daily'
			AND DAY(uch.created_at) = DAY(NOW())
			AND MONTH(uch.created_at) = MONTH(NOW())
			AND YEAR(uch.created_at) = YEAR(NOW())
			""", nativeQuery = true)
	List<UserCoinHistory> findTodayDailyHistoryByDiscordId(@Param("discordId") String discordId);

}

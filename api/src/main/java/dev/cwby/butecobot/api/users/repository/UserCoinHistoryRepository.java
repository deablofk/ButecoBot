package dev.cwby.butecobot.api.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.cwby.butecobot.api.users.domain.UserCoinHistory;

/**
 * UserCoinHistoryRepository
 */
@Repository
public interface UserCoinHistoryRepository extends JpaRepository<UserCoinHistory, Long> {
}

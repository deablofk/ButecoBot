package dev.cwby.butecobot.api.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.cwby.butecobot.api.users.domain.UserChangeHistory;

import java.util.List;

/**
 * UserChangeHistoryRepository
 */
public interface UserChangeHistoryRepository extends JpaRepository<UserChangeHistory, Long> {

	List<UserChangeHistory> findByUserId(Integer userId);

}

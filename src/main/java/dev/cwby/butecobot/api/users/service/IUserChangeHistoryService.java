package dev.cwby.butecobot.api.users.service;

import java.util.List;
import java.util.Optional;

import dev.cwby.butecobot.api.users.domain.UserChangeHistory;

/**
 * IUserChangeHistoryService
 */
public interface IUserChangeHistoryService {

	UserChangeHistory save(UserChangeHistory history);

	Optional<UserChangeHistory> findById(Long id);

	List<UserChangeHistory> findByUserId(Integer userId);

	List<UserChangeHistory> findAll();

	void deleteById(Long id);
}

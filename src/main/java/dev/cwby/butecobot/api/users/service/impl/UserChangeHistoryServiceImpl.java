package dev.cwby.butecobot.api.users.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.cwby.butecobot.api.users.domain.UserChangeHistory;
import dev.cwby.butecobot.api.users.repository.UserChangeHistoryRepository;
import dev.cwby.butecobot.api.users.service.IUserChangeHistoryService;
import lombok.RequiredArgsConstructor;

/**
 * UserChangeHistoryService
 */
@Service
@RequiredArgsConstructor
public class UserChangeHistoryServiceImpl implements IUserChangeHistoryService {

	private final UserChangeHistoryRepository repository;

	@Override
	public UserChangeHistory save(UserChangeHistory history) {
		return repository.save(history);
	}

	@Override
	public Optional<UserChangeHistory> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<UserChangeHistory> findByUserId(Integer userId) {
		return repository.findByUserId(userId);
	}

	@Override
	public List<UserChangeHistory> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

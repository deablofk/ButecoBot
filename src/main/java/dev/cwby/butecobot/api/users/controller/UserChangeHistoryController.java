package dev.cwby.butecobot.api.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.users.domain.UserChangeHistory;
import dev.cwby.butecobot.api.users.service.IUserChangeHistoryService;

import java.util.List;

/**
 * UserChangeHistoryController
 */
@RestController
@RequiredArgsConstructor
public class UserChangeHistoryController implements UserChangeHistoryApi {

	private final IUserChangeHistoryService service;

	@Override
	public ResponseEntity<UserChangeHistory> create(UserChangeHistory history) {
		return ResponseEntity.ok(service.save(history));
	}

	@Override
	public ResponseEntity<UserChangeHistory> findById(Long id) {
		return service.findById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<List<UserChangeHistory>> findByUserId(Integer userId) {
		return ResponseEntity.ok(service.findByUserId(userId));
	}

	@Override
	public ResponseEntity<List<UserChangeHistory>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

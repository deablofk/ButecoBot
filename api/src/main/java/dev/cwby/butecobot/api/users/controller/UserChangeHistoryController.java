package dev.cwby.butecobot.api.users.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.users.mapper.UserChangeHistoryMapper;
import dev.cwby.butecobot.api.users.service.IUserChangeHistoryService;
import dev.cwby.butecobot.users.dto.UserChangeHistoryRequest;
import dev.cwby.butecobot.users.dto.UserChangeHistoryResponse;
import lombok.RequiredArgsConstructor;

/**
 * UserChangeHistoryController
 */
@RestController
@RequiredArgsConstructor
public class UserChangeHistoryController implements UserChangeHistoryApi {

	private final IUserChangeHistoryService service;
	private static final UserChangeHistoryMapper mapper = UserChangeHistoryMapper.INSTANCE;

	@Override
	public ResponseEntity<UserChangeHistoryResponse> create(UserChangeHistoryRequest history) {
		return ResponseEntity.ok(mapper.toResponse(service.save(mapper.toEntity(history))));
	}

	@Override
	public ResponseEntity<UserChangeHistoryResponse> findById(Long id) {
		return service.findById(id)
				.map(x -> ResponseEntity.ok(mapper.toResponse(x)))
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<List<UserChangeHistoryResponse>> findByUserId(Integer userId) {
		return ResponseEntity.ok(mapper.toResponses(service.findByUserId(userId)));
	}

	@Override
	public ResponseEntity<List<UserChangeHistoryResponse>> findAll() {
		return ResponseEntity.ok(mapper.toResponses(service.findAll()));
	}

	@Override
	public ResponseEntity<Void> deleteById(Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

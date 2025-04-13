package dev.cwby.butecobot.api.users.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.users.mapper.UserCoinHistoryMapper;
import dev.cwby.butecobot.api.users.service.IUserCoinHistoryService;
import dev.cwby.butecobot.users.dto.UserCoinHistoryRequest;
import dev.cwby.butecobot.users.dto.UserCoinHistoryResponse;
import lombok.RequiredArgsConstructor;

/**
 * UserCoinHistoryController
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coins/")
public class UserCoinHistoryController implements UserCoinHistoryApi {

	private final IUserCoinHistoryService service;
	private static final UserCoinHistoryMapper mapper = UserCoinHistoryMapper.INSTANCE;

	@Override
	@PostMapping
	public UserCoinHistoryResponse create(@RequestBody UserCoinHistoryRequest history) {
		return mapper.toResponse(service.save(mapper.toEntity(history)));
	}

	@Override
	@GetMapping("/{id}")
	public UserCoinHistoryResponse findById(@PathVariable Long id) {
		return service.findById(id).map(mapper::toResponse)
				.orElseThrow(() -> new RuntimeException("Histórico não encontrado"));
	}

	@Override
	@GetMapping
	public List<UserCoinHistoryResponse> findAll() {
		return mapper.toResponses(service.findAll());
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping("/total/{discordId}")
	public ResponseEntity<Map<String, Object>> getTotalCoins(@PathVariable String discordId) {
		BigDecimal total = service.findTotalCoinsByDiscordId(discordId);
		return ResponseEntity.ok(Map.of("totalCoins", total));
	}
}

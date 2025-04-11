package dev.cwby.butecobot.api.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.cwby.butecobot.api.users.domain.UserCoinHistory;
import dev.cwby.butecobot.api.users.service.IUserCoinHistoryService;
import lombok.RequiredArgsConstructor;

/**
 * UserCoinHistoryController
 */
@RestController
@RequiredArgsConstructor
public class UserCoinHistoryController implements UserCoinHistoryApi {

	private final IUserCoinHistoryService service;

	@Override
	@PostMapping
	public UserCoinHistory create(@RequestBody UserCoinHistory history) {
		return service.save(history);
	}

	@Override
	@GetMapping("/{id}")
	public UserCoinHistory findById(@PathVariable Long id) {
		return service.findById(id).orElseThrow(() -> new RuntimeException("Histórico não encontrado"));
	}

	@Override
	@GetMapping
	public List<UserCoinHistory> findAll() {
		return service.findAll();
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deleteById(id);
	}
}

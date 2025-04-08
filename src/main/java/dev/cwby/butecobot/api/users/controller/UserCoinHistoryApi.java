package dev.cwby.butecobot.api.users.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import dev.cwby.butecobot.api.users.domain.UserCoinHistory;

import java.util.List;

/**
 * UserCoinHistoryApi
 */
@Tag(name = "UsersCoinsHistory", description = "Endpoints related to the users' coin history")
public interface UserCoinHistoryApi {

	@Operation(summary = "Create new history record")
	UserCoinHistory create(UserCoinHistory history);

	@Operation(summary = "Find by ID")
	UserCoinHistory findById(Long id);

	@Operation(summary = "List all history records")
	List<UserCoinHistory> findAll();

	@Operation(summary = "Delete by ID")
	void delete(Long id);
}

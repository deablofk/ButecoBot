package dev.cwby.butecobot.api.users.controller;

import java.util.List;

import dev.cwby.butecobot.users.dto.UserCoinHistoryRequest;
import dev.cwby.butecobot.users.dto.UserCoinHistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * UserCoinHistoryApi
 */
@Tag(name = "UsersCoinsHistory", description = "Endpoints related to the users' coin history")
public interface UserCoinHistoryApi {

	@Operation(summary = "Create new history record")
	UserCoinHistoryResponse create(UserCoinHistoryRequest history);

	@Operation(summary = "Find by ID")
	UserCoinHistoryResponse findById(Long id);

	@Operation(summary = "List all history records")
	List<UserCoinHistoryResponse> findAll();

	@Operation(summary = "Delete by ID")
	void delete(Long id);
}

package dev.cwby.butecobot.api.users.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.cwby.butecobot.api.users.domain.UserChangeHistory;

import java.util.List;

/**
 * UserChangeHistoryController
 */
@Tag(name = "Users Changes History", description = "Endpoints para histórico de alterações dos usuários")
@RequestMapping("/api/users-changes-history")
public interface UserChangeHistoryApi {

	@PostMapping
	@Operation(summary = "Salvar um novo histórico")
	ResponseEntity<UserChangeHistory> create(@RequestBody UserChangeHistory history);

	@GetMapping("/{id}")
	@Operation(summary = "Buscar por ID")
	ResponseEntity<UserChangeHistory> findById(@PathVariable Long id);

	@GetMapping("/user/{userId}")
	@Operation(summary = "Buscar histórico por ID do usuário")
	ResponseEntity<List<UserChangeHistory>> findByUserId(@PathVariable Integer userId);

	@GetMapping
	@Operation(summary = "Listar todos os históricos")
	ResponseEntity<List<UserChangeHistory>> findAll();

	@DeleteMapping("/{id}")
	@Operation(summary = "Excluir por ID")
	ResponseEntity<Void> deleteById(@PathVariable Long id);
}

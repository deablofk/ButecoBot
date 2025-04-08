package dev.cwby.butecobot.api.jokenpo.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JokenpoPlayer
 */
@Entity
@Table(name = "jokenpo_players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JokenpoPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "jokenpo_id", nullable = false)
	private Long jokenpoId;

	@Column(name = "user_id", nullable = false)
	private Long userId;

	@Column(nullable = false)
	private String move;

	@Column(nullable = false)
	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "enum('ganhou','perdeu','empate')")
	private Result result;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public enum Result {
		ganhou,
		perdeu,
		empate;
	}
}

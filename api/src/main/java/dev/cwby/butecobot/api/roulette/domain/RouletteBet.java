package dev.cwby.butecobot.api.roulette.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
 * RouletteBet
 */
@Entity
@Table(name = "roulette_bet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouletteBet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "roulette_id")
	private Integer rouletteId;

	@Column(name = "bet_amount")
	private Integer betAmount;

	@Column
	private Integer choice;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}

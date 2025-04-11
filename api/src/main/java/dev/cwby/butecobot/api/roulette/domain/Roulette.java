package dev.cwby.butecobot.api.roulette.domain;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Roulette
 */
@Entity
@Table(name = "roulette")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Roulette {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column
	private Integer result;

	@Column(nullable = false)
	private Integer status;

	@Column(length = 255)
	private String description;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(precision = 10, scale = 2)
	private BigDecimal amount;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}

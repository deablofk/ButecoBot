package dev.cwby.butecobot.api.users.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * UserChangeHistory
 */
@Entity
@Table(name = "users_changes_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserChangeHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Column(nullable = false, length = 255)
	private String info;

	@Column(name = "event_label", nullable = false, length = 255)
	private String eventLabel;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}

package dev.cwby.butecobot.api.users.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(name = "discord_username_UNIQUE", columnNames = "username"),
		@UniqueConstraint(name = "discord_user_id_UNIQUE", columnNames = "discord_id")
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "discord_id", nullable = false)
	private String discordId;

	@Column(nullable = false)
	private String username;

	private String nickname;

	private String avatar;

	@Column(name = "received_initial_coins", nullable = false)
	private boolean receivedInitialCoins;

	@Column(name = "is_admin", nullable = false)
	private boolean isAdmin;

	@Column(name = "joined_at")
	private LocalDateTime joinedAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Column(name = "created_at")
	private LocalDateTime createdAt;
}

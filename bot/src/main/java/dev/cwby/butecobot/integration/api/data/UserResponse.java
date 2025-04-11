package dev.cwby.butecobot.integration.api.data;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * UserResponse
 */
@Data
public class UserResponse {

	private long id;
	private String discordId;
	private String username;
	private String nickname;
	private String avatar;
	private boolean receivedInitialCoins;
	private LocalDateTime joinedAt;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;
	private boolean admin;

}

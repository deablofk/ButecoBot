
package dev.cwby.butecobot.users.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserRequest(
		@JsonProperty("discord_id") String discordId,
		String username,
		String nickname,
		String avatar,
		@JsonProperty("joined_at") LocalDateTime joinedAt,
		@JsonProperty("received_initial_coins") boolean receivedInitialCoins) {

	public UserRequest(UserResponse response) {
		this(response.discordId(), response.username(), response.nickname(), response.avatar(), response.joinedAt(),
				response.receivedInitialCoins());
	}

	public UserRequest(UserResponse response, boolean receivedInitialCoins) {
		this(response.discordId(), response.username(), response.nickname(), response.avatar(), response.joinedAt(),
				receivedInitialCoins);
	}
}

package dev.cwby.butecobot.users.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserResponse
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserResponse(
		Long id,
		@JsonProperty("discord_id") String discordId,
		String username,
		String nickname,
		String avatar,
		@JsonProperty("joined_at") LocalDateTime joinedAt,
		@JsonProperty("received_initial_coins") boolean receivedInitialCoins,
		BigDecimal totalCoins,
		boolean canReceiveDailyCoins) {
}

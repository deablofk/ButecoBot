package dev.cwby.butecobot.users.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserCoinHistoryResponse
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserCoinHistoryResponse(
		@JsonProperty("user_id") String userId,
		BigDecimal amount,
		String type,
		String description) {
}

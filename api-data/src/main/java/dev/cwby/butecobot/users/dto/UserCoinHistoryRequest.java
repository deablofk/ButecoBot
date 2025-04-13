package dev.cwby.butecobot.users.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserCoinHistory
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserCoinHistoryRequest(
		@JsonProperty("user_id") String userId,
		@JsonProperty("entity_id") String entityId,
		BigDecimal amount,
		String type,
		String description) {
}

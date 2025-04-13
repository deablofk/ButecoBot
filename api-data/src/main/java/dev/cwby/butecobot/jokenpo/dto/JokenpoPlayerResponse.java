package dev.cwby.butecobot.jokenpo.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JokenpoPlayerResponse
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record JokenpoPlayerResponse(
		@JsonProperty("jokenpo_id") Long jokenpoId,
		@JsonProperty("user_id") Long userId,
		String move,
		BigDecimal amount,
		String result) {
}

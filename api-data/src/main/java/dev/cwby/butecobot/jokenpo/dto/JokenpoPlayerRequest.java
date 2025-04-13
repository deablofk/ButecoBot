package dev.cwby.butecobot.jokenpo.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JokenpoPlayerRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record JokenpoPlayerRequest(
		@JsonProperty("jokenpo_id") Long jokenpoId,
		@JsonProperty("user_id") Long userId,
		String move,
		BigDecimal amount,
		String result) {
}

package dev.cwby.butecobot.jokenpo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JokenpoRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record JokenpoRequest(
		@JsonProperty("created_by") Long createdBy,
		@JsonProperty("bot_move") String botMove) {
}

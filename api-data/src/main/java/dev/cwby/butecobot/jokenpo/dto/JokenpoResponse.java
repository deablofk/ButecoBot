package dev.cwby.butecobot.jokenpo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * JokenpoResponse
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record JokenpoResponse(
		@JsonProperty("created_by") Long createdBy,
		@JsonProperty("bot_move") String botMove) {
}

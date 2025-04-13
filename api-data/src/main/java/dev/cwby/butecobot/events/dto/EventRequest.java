package dev.cwby.butecobot.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record EventRequest(
		@JsonProperty("created_by") Integer createdBy,
		@JsonProperty("winner_choice_id") Integer winnerChoiceId,
		@JsonProperty("name") String name,
		@JsonProperty("status") Byte status) {
}

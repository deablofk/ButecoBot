package dev.cwby.butecobot.events.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record EventChoiceRequest(
		@JsonProperty("event_id") Integer eventId,
		@JsonProperty("choice") String choice,
		@JsonProperty("description") String description) {
}

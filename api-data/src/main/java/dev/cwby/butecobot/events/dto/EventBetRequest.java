
package dev.cwby.butecobot.events.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * EventBetRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record EventBetRequest(
		@JsonProperty("user_id") Integer userId,
		@JsonProperty("event_id") Integer eventId,
		@JsonProperty("choice_id") Integer choiceId,
		@JsonProperty("amount") BigDecimal amount) {
}

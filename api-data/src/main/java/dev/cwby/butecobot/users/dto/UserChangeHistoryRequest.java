package dev.cwby.butecobot.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserChangeHistoryRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserChangeHistoryRequest(
		@JsonProperty("user_id") Integer userId,
		String info,
		@JsonProperty("event_label") String eventLabel) {
}

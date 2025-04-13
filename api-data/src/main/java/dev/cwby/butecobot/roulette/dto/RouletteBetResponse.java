package dev.cwby.butecobot.roulette.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RouletteBetResponse
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RouletteBetResponse(
		@JsonProperty("user_id") Integer userId,
		@JsonProperty("roulette_id") Integer rouletteId,
		@JsonProperty("bet_amount") Integer betAmount,
		@JsonProperty Integer choice) {
}

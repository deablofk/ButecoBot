package dev.cwby.butecobot.roulette.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RouletteBetRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RouletteBetRequest(
		@JsonProperty("user_id") Integer userId,
		@JsonProperty("roulette_id") Integer rouletteId,
		@JsonProperty("bet_amount") Integer betAmount,
		@JsonProperty Integer choice) {

}

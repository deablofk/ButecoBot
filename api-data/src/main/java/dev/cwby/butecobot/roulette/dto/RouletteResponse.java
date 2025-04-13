package dev.cwby.butecobot.roulette.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RouletteResponse
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RouletteResponse(
		@JsonProperty("created_by") Integer createdBy,
		Integer result,
		Integer status,
		String description,
		BigDecimal amount) {
}

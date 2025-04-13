package dev.cwby.butecobot.roulette.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * RouletteRequest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RouletteRequest(
		@JsonProperty("created_by") Integer createdBy,
		Integer result,
		Integer status,
		String description,
		BigDecimal amount) {
}

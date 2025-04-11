package dev.cwby.butecobot.integration.api;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.cwby.butecobot.ic.exception.CommandFailException;
import net.dv8tion.jda.api.entities.Member;

/**
 * ButecoApiClient
 */
public class ButecoApiClient {

	private final HttpClient httpClient;
	private final ObjectMapper objectMapper;
	private final String baseUrl;

	public ButecoApiClient(String baseUrl) {
		this.httpClient = HttpClient.newHttpClient();
		this.objectMapper = new ObjectMapper();
		this.baseUrl = baseUrl;
	}

	private <T> T fromJson(String body, Class<T> clazz) throws CommandFailException {
		try {
			return objectMapper.readValue(body, clazz);
		} catch (JsonProcessingException e) {
			throw new CommandFailException("Cant deserialize json to object");
		}
	}

	private String getValueFromJsonBody(String key, String body) throws CommandFailException {
		try {
			return objectMapper.readTree(body).get(key).asText();
		} catch (JsonProcessingException e) {
			throw new CommandFailException("Cant deserialize json to object");
		}
	}

	private HttpResponse<String> get(String url) throws CommandFailException {
		try {
			var request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.header("Accept", "application/json")
					.GET()
					.build();

			return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new CommandFailException();
		}
	}

	public Optional<UserResponse> getUserByDiscordId(String discordId) throws CommandFailException {
		String url = String.format("%s/api/users/discord/%s", baseUrl, discordId);
		HttpResponse<String> response = get(url);

		if (response.statusCode() == 200) {
			return Optional.of(fromJson(response.body(), UserResponse.class));
		}

		return Optional.empty();
	}

	public Optional<BigDecimal> getTotalCoinsByDiscordId(String discordId) throws CommandFailException {
		String url = String.format("%s/api/coins/total/%s", baseUrl, discordId);
		HttpResponse<String> response = get(url);

		if (response.statusCode() == 200) {
			String coinsString = getValueFromJsonBody("totalCoins", response.body());
			return Optional.of(new BigDecimal(coinsString));
		}

		return Optional.empty();
	}

	public void registerAndGiveCoins(Member member) {
		// $interaction->member->user['id'],
		// $interaction->member->user['username'],
		// $interaction->member->user->global_name,
		// $interaction->member->user->avatar,
		// $interaction->member->joined_at->format('Y-m-d H:i:s')

	}
}

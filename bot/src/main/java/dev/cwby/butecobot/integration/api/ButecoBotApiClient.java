package dev.cwby.butecobot.integration.api;

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * ButecoBotApiClient
 */
public class ButecoBotApiClient {

	private final ObjectMapper mapper;
	private final Retrofit retrofit;
	public final ApiService api;

	public ButecoBotApiClient(String url) {
		this.mapper = new ObjectMapper().registerModule(new JavaTimeModule());
		this.retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(JacksonConverterFactory.create(mapper))
				.build();
		this.api = retrofit.create(ApiService.class);
	}

	public <T> Optional<T> send(Call<T> call) {
		try {
			return Optional.ofNullable(call.execute().body());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Optional.empty();
	}

}

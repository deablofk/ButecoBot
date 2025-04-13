package dev.cwby.butecobot.integration.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import dev.cwby.butecobot.events.dto.EventBetRequest;
import dev.cwby.butecobot.events.dto.EventBetResponse;
import dev.cwby.butecobot.events.dto.EventChoiceRequest;
import dev.cwby.butecobot.events.dto.EventChoiceResponse;
import dev.cwby.butecobot.events.dto.EventRequest;
import dev.cwby.butecobot.events.dto.EventResponse;
import dev.cwby.butecobot.jokenpo.dto.JokenpoPlayerRequest;
import dev.cwby.butecobot.jokenpo.dto.JokenpoPlayerResponse;
import dev.cwby.butecobot.jokenpo.dto.JokenpoRequest;
import dev.cwby.butecobot.jokenpo.dto.JokenpoResponse;
import dev.cwby.butecobot.roulette.dto.RouletteBetRequest;
import dev.cwby.butecobot.roulette.dto.RouletteBetResponse;
import dev.cwby.butecobot.roulette.dto.RouletteRequest;
import dev.cwby.butecobot.roulette.dto.RouletteResponse;
import dev.cwby.butecobot.users.dto.UserChangeHistoryRequest;
import dev.cwby.butecobot.users.dto.UserChangeHistoryResponse;
import dev.cwby.butecobot.users.dto.UserCoinHistoryRequest;
import dev.cwby.butecobot.users.dto.UserCoinHistoryResponse;
import dev.cwby.butecobot.users.dto.UserRequest;
import dev.cwby.butecobot.users.dto.UserResponse;
/**
 * ApiService
 */
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

	// ----------- USERS -----------
	@GET("/api/users")
	Call<List<UserResponse>> getAllUsers();

	@GET("/api/users/{id}")
	Call<UserResponse> getUserById(@Path("id") long id);

	@GET("/api/users/discord/{discordId}")
	Call<UserResponse> getUserByDiscordId(@Path("discordId") String discordId);

	@POST("/api/users")
	Call<UserResponse> createUser(@Body UserRequest user);

	@PUT("/api/users/{id}")
	Call<UserResponse> updateUser(@Path("id") long id, @Body UserRequest user);

	@DELETE("/api/users/{id}")
	Call<Void> deleteUser(@Path("id") long id);

	// ----------- EVENTS -----------
	@POST("/api/events")
	Call<EventResponse> createEvent(@Body EventRequest event);

	@GET("/api/events/{id}")
	Call<EventResponse> getEventById(@Path("id") long id);

	@PUT("/api/events/{id}")
	Call<EventResponse> updateEvent(@Path("id") long id, @Body EventRequest event);

	@DELETE("/api/events/{id}")
	Call<Void> deleteEvent(@Path("id") long id);

	// ----------- EVENT CHOICES -----------
	@POST("/api/choices")
	Call<EventChoiceResponse> createChoice(@Body EventChoiceRequest choice);

	@GET("/api/choices/{id}")
	Call<EventChoiceResponse> getChoiceById(@Path("id") long id);

	@PUT("/api/choices/{id}")
	Call<EventChoiceResponse> updateChoice(@Path("id") long id, @Body EventChoiceRequest choice);

	@DELETE("/api/choices/{id}")
	Call<Void> deleteChoice(@Path("id") long id);

	// ----------- EVENT BETS -----------
	@POST("/api/bets")
	Call<EventBetResponse> createBet(@Body EventBetRequest bet);

	@GET("/api/bets/{id}")
	Call<EventBetResponse> getBetById(@Path("id") long id);

	@PUT("/api/bets/{id}")
	Call<EventBetResponse> updateBet(@Path("id") long id, @Body EventBetRequest bet);

	@DELETE("/api/bets/{id}")
	Call<Void> deleteBet(@Path("id") long id);

	// ----------- USERS CHANGE HISTORY -----------
	@GET("/api/users-changes-history")
	Call<List<UserChangeHistoryResponse>> getAllUserChanges();

	@POST("/api/users-changes-history")
	Call<UserChangeHistoryResponse> createUserChange(@Body UserChangeHistoryRequest change);

	@GET("/api/users-changes-history/{id}")
	Call<UserChangeHistoryResponse> getUserChangeById(@Path("id") long id);

	@GET("/api/users-changes-history/user/{userId}")
	Call<List<UserChangeHistoryResponse>> getUserChangeByUserId(@Path("userId") int userId);

	@DELETE("/api/users-changes-history/{id}")
	Call<Void> deleteUserChange(@Path("id") long id);

	// ----------- ROULETTE -----------
	@GET("/api/roulette")
	Call<List<RouletteResponse>> getAllRoulettes();

	@POST("/api/roulette")
	Call<RouletteResponse> createRoulette(@Body RouletteRequest roulette);

	@GET("/api/roulette/{id}")
	Call<RouletteResponse> getRouletteById(@Path("id") long id);

	@DELETE("/api/roulette/{id}")
	Call<Void> deleteRoulette(@Path("id") long id);

	// ----------- ROULETTE BET -----------
	@GET("/api/roulette-bet")
	Call<List<RouletteBetResponse>> getAllRouletteBets();

	@POST("/api/roulette-bet")
	Call<RouletteBetResponse> createRouletteBet(@Body RouletteBetRequest bet);

	@GET("/api/roulette-bet/{id}")
	Call<RouletteBetResponse> getRouletteBetById(@Path("id") long id);

	@DELETE("/api/roulette-bet/{id}")
	Call<Void> deleteRouletteBet(@Path("id") long id);

	// ----------- JOKENPO -----------
	@GET("/api/jokenpo")
	Call<List<JokenpoResponse>> getAllJokenpo();

	@POST("/api/jokenpo")
	Call<JokenpoResponse> createJokenpo(@Body JokenpoRequest request);

	@GET("/api/jokenpo/{id}")
	Call<JokenpoResponse> getJokenpoById(@Path("id") long id);

	@DELETE("/api/jokenpo/{id}")
	Call<Void> deleteJokenpo(@Path("id") long id);

	// ----------- JOKENPO PLAYERS -----------
	@GET("/api/jokenpo-players")
	Call<List<JokenpoPlayerResponse>> getAllJokenpoPlayers();

	@POST("/api/jokenpo-players")
	Call<JokenpoPlayerResponse> createJokenpoPlayer(@Body JokenpoPlayerRequest request);

	@GET("/api/jokenpo-players/{id}")
	Call<JokenpoPlayerResponse> getJokenpoPlayerById(@Path("id") long id);

	@DELETE("/api/jokenpo-players/{id}")
	Call<Void> deleteJokenpoPlayer(@Path("id") long id);

	// ----------- COINS HISTORY -----------
	@GET("/api/coins/")
	Call<List<UserCoinHistoryResponse>> getAllCoinHistory();

	@POST("/api/coins/")
	Call<UserCoinHistoryResponse> createCoinHistory(@Body UserCoinHistoryRequest request);

	@GET("/api/coins/{id}")
	Call<UserCoinHistoryResponse> getCoinHistoryById(@Path("id") long id);

	@DELETE("/api/coins/{id}")
	Call<Void> deleteCoinHistory(@Path("id") long id);

	@GET("/api/coins/total/{discordId}")
	Call<Map<String, Object>> getTotalCoins(@Path("discordId") String discordId);

	// ----------- AUTH -----------
	@GET("/api/auth/success")
	Call<Map<String, String>> authSuccess();
}

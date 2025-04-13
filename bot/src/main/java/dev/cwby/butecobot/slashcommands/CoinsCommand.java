package dev.cwby.butecobot.slashcommands;

import java.awt.Color;
import java.math.BigDecimal;

import dev.cwby.butecobot.ic.annotation.command.SlashCommand;
import dev.cwby.butecobot.ic.exception.CommandFailException;
import dev.cwby.butecobot.media.ButecoEmbeds;
import dev.cwby.butecobot.media.ButecoMedia;
import dev.cwby.butecobot.users.dto.UserCoinHistoryRequest;
import dev.cwby.butecobot.users.dto.UserRequest;
import dev.cwby.butecobot.users.dto.UserResponse;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

/**
 * CoinsCommand
 */
@SlashCommand(name = "coins", description = "Consulta extrato das coins")
public class CoinsCommand extends SlashBaseCommand {
	private static final BigDecimal DAILY = new BigDecimal("100");

	@Override
	public void onCooldown(SlashCommandInteractionEvent event) throws CommandFailException {
		event.replyEmbeds(ButecoEmbeds.COOLDOWN_EXTRACT).setEphemeral(true).queue();
	}

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) throws CommandFailException {
		Member member = event.getMember();
		String memberId = event.getMember().getId();

		UserResponse userResponse = client.send(api.getUserByDiscordId(memberId)).orElse(null);

		if (userResponse == null) {
			var data = client.send(api.createUser(buildUserRequest(member))).get();
			client.send(api.createCoinHistory(buildCoinHistory(data.id(), "Initial")));
			event.replyEmbeds(ButecoEmbeds.STARTER_COINS).setEphemeral(true).queue();
			return;
		}

		if (!userResponse.receivedInitialCoins()) {
			client.send(api.createCoinHistory(buildCoinHistory(userResponse.id(), "Initial")));
			event.replyEmbeds(ButecoEmbeds.STARTER_COINS).setEphemeral(true).queue();
		}

		BigDecimal totalCoins = userResponse.totalCoins();
		var builder = new StringBuilder();
		if (userResponse.canReceiveDailyCoins()) {
			client.send(api.createCoinHistory(buildCoinHistory(userResponse.id(), "Daily")));
			builder.append("**+").append(DAILY).append(" diárias**\n");
			totalCoins = totalCoins.add(DAILY);
		}

		builder.append("**B$ ").append(totalCoins).append("** coins");

		var eb = new EmbedBuilder();
		eb.setTitle("Saldo");
		eb.setDescription(builder.toString());
		eb.setThumbnail(ButecoMedia.ONE_COIN);
		eb.setColor(totalCoins.compareTo(BigDecimal.ZERO) == 0 ? Color.decode("#FF0000") : Color.decode("#00FF00"));
		event.replyEmbeds(eb.build()).queue();
	}

	public UserRequest buildUserRequest(Member member) {
		User user = member.getUser();
		return new UserRequest(member.getId(), member.getEffectiveName(), user.getGlobalName(),
				user.getEffectiveAvatarUrl(), member.getTimeJoined().toLocalDateTime(), true);
	}

	public UserCoinHistoryRequest buildCoinHistory(Long id, String type) {
		return new UserCoinHistoryRequest(id, null, DAILY, type, null);
	}

}

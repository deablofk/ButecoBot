package dev.cwby.butecobot.slashcommands;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.Optional;

import dev.cwby.butecobot.ButecoBot;
import dev.cwby.butecobot.ic.ISlashCommand;
import dev.cwby.butecobot.ic.annotation.command.SlashCommand;
import dev.cwby.butecobot.ic.exception.CommandFailException;
import dev.cwby.butecobot.integration.api.data.UserResponse;
import media.ButecoEmbeds;
import media.ButecoMedia;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

/**
 * CoinsCommand
 */
@SlashCommand(name = "coins", description = "Consulta extrato das coins")
public class CoinsCommand implements ISlashCommand {

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) throws CommandFailException {
		String memberId = event.getMember().getId();

		Optional<UserResponse> userResponse = ButecoBot.REST.getUserByDiscordId(memberId);
		if (userResponse.isEmpty()) {
			ButecoBot.REST.registerAndGiveCoins(event.getMember());
			event.replyEmbeds(ButecoEmbeds.STARTER_COINS).setEphemeral(true).queue();
			return;
		}

		BigDecimal totalCoins = ButecoBot.REST.getTotalCoinsByDiscordId(memberId).get();
		BigDecimal dailyCoins = new BigDecimal("100");

		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Saldo");
		eb.setDescription("**+" + dailyCoins + " diárias**\n**B$ " + totalCoins + "** coins");
		eb.setThumbnail(ButecoMedia.ONE_COIN);
		eb.setColor(totalCoins.compareTo(BigDecimal.ZERO) == 0 ? Color.decode("#FF0000") : Color.decode("#00FF00"));

		event.replyEmbeds(eb.build()).queue();
	}

}

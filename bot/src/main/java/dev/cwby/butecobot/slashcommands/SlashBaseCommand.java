package dev.cwby.butecobot.slashcommands;

import dev.cwby.butecobot.ButecoBot;
import dev.cwby.butecobot.ic.ISlashCommand;
import dev.cwby.butecobot.ic.exception.CommandFailException;
import dev.cwby.butecobot.integration.api.ApiService;
import dev.cwby.butecobot.integration.api.ButecoBotApiClient;
import dev.cwby.butecobot.media.ButecoEmbeds;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

/**
 * BaseCommand
 */
public abstract class SlashBaseCommand implements ISlashCommand {

	public static final ApiService api = ButecoBot.REST.api;
	public static final ButecoBotApiClient client = ButecoBot.REST;

	@Override
	public void onCooldown(SlashCommandInteractionEvent event) throws CommandFailException {
		event.replyEmbeds(ButecoEmbeds.COOLDOWN).setEphemeral(true).queue();
	}

}

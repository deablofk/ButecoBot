package dev.cwby.butecobot;

import dev.cwby.butecobot.ic.EventListenerHandler;
import dev.cwby.butecobot.ic.SlashCommandHandler;
import dev.cwby.butecobot.integration.api.ButecoApiClient;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

/**
 * ButecoBot
 */
public class ButecoBot {

	private static final Dotenv DOTENV = Dotenv.configure().filename(".env").load();
	public static final ButecoApiClient REST = new ButecoApiClient(DOTENV.get("API_URL"));

	public static void main(String[] args) {
		var builder = JDABuilder.createDefault(DOTENV.get("DISCORD_TOKEN"))
				.enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS));
		EventListenerHandler.getEventListeners().forEach(builder::addEventListeners);

		var jda = builder.build();
		jda.updateCommands().addCommands(SlashCommandHandler.getSlashCommandsRegistry()).queue();
	}

}

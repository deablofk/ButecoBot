package dev.cwby.butecobot;

import java.util.Map;

import dev.cwby.butecobot.cooldown.CooldownManager;
import dev.cwby.butecobot.ic.ISlashCommand;
import dev.cwby.butecobot.ic.SlashCommandHandler;
import dev.cwby.butecobot.ic.annotation.EventListener;
import dev.cwby.butecobot.ic.exception.CommandFailException;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * ReadyEventListener
 */
@EventListener
public class GlobalEventListener extends ListenerAdapter {

	private final Map<String, ISlashCommand> executors = SlashCommandHandler.getSlashCommandsExecutors();

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		String commandName = event.getName();
		ISlashCommand executor = executors.get(commandName);

		if (executor == null) {
			return;
		}

		try {
			if (executor.isCooldownEnabled() && CooldownManager.isOnCooldown(event.getMember().getId())) {
				executor.onCooldown(event);
			} else {
				executor.onSlashCommandInteraction(event);
			}
		} catch (CommandFailException e) {
			e.printStackTrace();
		}
	}
}

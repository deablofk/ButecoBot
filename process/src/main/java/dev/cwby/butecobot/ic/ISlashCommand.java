package dev.cwby.butecobot.ic;

import dev.cwby.butecobot.ic.exception.CommandFailException;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

/**
 * ISlashCommand
 */
public interface ISlashCommand {

	void onSlashCommandInteraction(SlashCommandInteractionEvent event) throws CommandFailException;

}

package dev.cwby.butecobot.ic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.utils.data.DataObject;

/**
 * SlashCommandHandler
 */
public class SlashCommandHandler {

	private static final Map<String, ISlashCommand> SLASH_COMMANDS_EXECUTORS = new HashMap<>();
	private static final List<SlashCommandData> SLASH_COMMANDS_REGISTRY = new ArrayList<>();

	static {
		try {
			// it uses reflection, but since this usage is so light, i dont think this will
			// cause any impact in performance except a negligible performance decrease in
			// the
			// program initialization.
			Class.forName("dev.cwby.butecobot.ic.initializer.AOTSlashCommandInitializer");
		} catch (ClassNotFoundException e) {
			System.out
					.println("[ANNOTATION_PROCESSOR] Cant initialize the class AOTSlashCommandInitializer: " + e.getMessage());
		}
	}

	private SlashCommandHandler() {
	}

	public static void registerSlashCommand(ISlashCommand slashCommand, String slashCommandJson) {
		SlashCommandData slashCommandData = SlashCommandData.fromData(DataObject.fromJson(slashCommandJson));
		SLASH_COMMANDS_REGISTRY.add(slashCommandData);
		SLASH_COMMANDS_EXECUTORS.put(slashCommandData.getName(), slashCommand);
	}

	public static Map<String, ISlashCommand> getSlashCommandsExecutors() {
		return SLASH_COMMANDS_EXECUTORS;
	}

	public static List<SlashCommandData> getSlashCommandsRegistry() {
		return SLASH_COMMANDS_REGISTRY;
	}

}

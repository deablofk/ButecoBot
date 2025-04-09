package dev.cwby.butecobot.ic.generator;

import java.io.IOException;
import java.util.Map;

import javax.annotation.processing.Filer;
import javax.lang.model.element.TypeElement;

import com.palantir.javapoet.ClassName;
import com.palantir.javapoet.CodeBlock;
import com.palantir.javapoet.JavaFile;
import com.palantir.javapoet.TypeSpec;

import dev.cwby.butecobot.ic.EventListenerHandler;
import dev.cwby.butecobot.ic.SlashCommandHandler;
import dev.cwby.butecobot.ic.annotation.command.Choice;
import dev.cwby.butecobot.ic.annotation.command.Option;
import dev.cwby.butecobot.ic.annotation.command.SlashCommand;
import net.dv8tion.jda.api.interactions.InteractionContextType;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;
import net.dv8tion.jda.api.utils.data.DataObject;

/**
 * SlashCommandCodeGenerator
 */
public class SlashCommandCodeGenerator implements ICodeGenerator {

	private SlashCommandData annotationToSlashCommand(SlashCommand annotation) {
		SlashCommandData commandData = Commands.slash(annotation.name(), annotation.description());

		for (Option option : annotation.options()) {
			OptionData optionData = new OptionData(option.type(), option.name(), option.description(), option.required());
			for (Choice choice : option.choices()) {
				// TODO: parse choice correctly instead of putting everything in string use:
				// string, long and double!
				optionData.addChoice(choice.name(), choice.value());
			}
			commandData.addOptions(optionData);
		}

		if (annotation.requiredPermissions().length > 0) {
			commandData.setDefaultPermissions(DefaultMemberPermissions.enabledFor(annotation.requiredPermissions()));
		}
		return commandData;
	}

	@Override
	public void write(Map<String, TypeElement> elements, Filer filer) {
		var staticBlock = CodeBlock.builder();

		for (Map.Entry<String, TypeElement> e : elements.entrySet()) {
			SlashCommandData commandData = annotationToSlashCommand(e.getValue().getAnnotation(SlashCommand.class));
			String jsonData = commandData.toData().toString();

			System.out.println("[ANNOTATION_PROCESSOR] Registering SlashCommand Class: " + e.getKey());
			ClassName listenerToRegister = ClassName.get(e.getValue());
			staticBlock.addStatement("$T.registerSlashCommand(new $T(), $S)", ClassName.get(SlashCommandHandler.class), listenerToRegister, jsonData);
		}
		var typeSpec = TypeSpec.classBuilder("AOTSlashCommandInitializer").addStaticBlock(staticBlock.build()).build();

		try {
			JavaFile.builder(getFolderInitializer(), typeSpec).build().writeTo(filer);
		} catch (IOException e) {
			System.out
					.println("[ANNOTATION_PROCESSOR] Cant write the AOTSlashCommandInitializer to a file: " + e.getMessage());
		}
	}

}

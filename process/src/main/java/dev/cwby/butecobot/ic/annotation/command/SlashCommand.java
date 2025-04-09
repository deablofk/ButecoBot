package dev.cwby.butecobot.ic.annotation.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.dv8tion.jda.api.Permission;

/**
 * SlashCommand
 * This Annotation MUST be used along ISlashCommand interface or a class that
 * implements it, and the actual class must have a EMPTY CONSTRUCTOR.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface SlashCommand {

	String name();

	String description();

	Option[] options() default {};

	Permission[] requiredPermissions() default {};

}

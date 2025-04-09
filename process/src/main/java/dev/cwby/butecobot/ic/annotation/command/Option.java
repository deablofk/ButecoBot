package dev.cwby.butecobot.ic.annotation.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.dv8tion.jda.api.interactions.commands.OptionType;

/**
 * Option
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Option {

	OptionType type();

	String name();

	String description();

	boolean required() default false;

	Choice[] choices() default {};

}

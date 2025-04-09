package dev.cwby.butecobot.ic.exception;

/**
 * CommandFailException
 */
public class CommandFailException extends Exception {

	public CommandFailException() {
		super("Command did not execute correctly.");
	}

	public CommandFailException(String message) {
		super(message);
	}

}

package dev.cwby.butecobot.api.common.exception;

import org.springframework.http.HttpStatus;

/**
 * ErrorCode
 */
public enum ErrorCode {

	DISCORD_USER_NOT_FOUND("USER_001", "Discord User Not Found", HttpStatus.NOT_FOUND),
	DISCORD_USER_ALREADY_EXISTS("USER_002", "Discord User Already Exists", HttpStatus.NOT_FOUND);

	private final String code;
	private final String message;
	private final HttpStatus status;

	ErrorCode(String code, String message, HttpStatus status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public String code() {
		return code;
	}

	public String message() {
		return message;
	}

	public HttpStatus status() {
		return status;
	}

}

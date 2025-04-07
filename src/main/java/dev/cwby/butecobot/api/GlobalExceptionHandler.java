package dev.cwby.butecobot.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.cwby.butecobot.api.common.exception.ApiException;
import dev.cwby.butecobot.api.common.exception.ErrorCode;
import dev.cwby.butecobot.api.common.exception.ErrorResponse;

/**
 * GlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {
		ErrorCode code = ex.getErrorCode();
		return ResponseEntity.status(code.status()).body(new ErrorResponse(code.code(), code.message()));
	}

}

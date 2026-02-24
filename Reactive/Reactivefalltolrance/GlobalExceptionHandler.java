package com.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * GlobalExceptionHandler is a customized exception handler.
 * By using @ControllerAdvice, you’ve told Spring to centralize
 * exception handling logic in one place instead of scattering 
 * try/catch blocks across controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntime(RuntimeException ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
				body("Something went wrong: " + ex.getMessage());
	}

	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).
				body("Invalid input: " + ex.getMessage());
	}
}

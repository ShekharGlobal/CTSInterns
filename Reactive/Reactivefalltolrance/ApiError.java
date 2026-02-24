package com.app;

import java.time.LocalDateTime;

public class ApiError {
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;

	public ApiError(int status, String error, String message, String path) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public int getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}

	public String getPath() {
		return path;
	}
}

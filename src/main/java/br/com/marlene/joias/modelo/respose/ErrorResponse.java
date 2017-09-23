package br.com.marlene.joias.modelo.respose;

public class ErrorResponse {
	private boolean status;
	private String message;
	private String cause;

	public ErrorResponse(String message, String cause) {
		this.cause = cause;
		this.status = false;
		this.message = message;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
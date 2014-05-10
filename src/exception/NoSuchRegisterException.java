package exception;

public class NoSuchRegisterException extends Exception {

	public NoSuchRegisterException() {
	}

	public NoSuchRegisterException(String message) {
		super(message);
	}

	public NoSuchRegisterException(Throwable cause) {
		super(cause);
	}

	public NoSuchRegisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchRegisterException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

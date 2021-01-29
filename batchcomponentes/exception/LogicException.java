package es.lacaixa.inu.batch.batchcomponentes.exception;

/**
 * {@link Exception} para fallos a nivel de ejecución
 * @author imontesi
 *
 */
public class LogicException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1462585525236763168L;

	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicException(String message) {
		super(message);
	}

	
}

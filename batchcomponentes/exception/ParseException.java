package es.lacaixa.inu.batch.batchcomponentes.exception;

/**
 * {@link Exception} para fallos durante el parsing del fichero de entrada
 * @author imontesi
 *
 */
public class ParseException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 460250520409267234L;

	public ParseException(String message) {
		super(message);
	}

}

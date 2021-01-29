package es.lacaixa.inu.batch.batchcomponentes.bo;

import java.io.Serializable;

/**
 * Clase base
 * @author imontesi
 *
 */
public class Reportable implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4017013935564938860L;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reportable [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	
	

}

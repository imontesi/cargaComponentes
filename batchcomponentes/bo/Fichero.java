package es.lacaixa.inu.batch.batchcomponentes.bo;

import java.io.File;

/**
 * Representa un fichero
 * @author imontesi
 *
 */
public class Fichero extends Reportable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9041658608291772733L;

	private String nombreFichero;
	
	private int totalLineas;
	private int lineasOk;
	
	public Fichero() {
		super();
		totalLineas = 0;
		lineasOk = 0;
	}

	public String getNombreFichero() {
		return nombreFichero;
	}

	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
	}


	public int getTotalLineas() {
		return totalLineas;
	}

	public void setTotalLineas(int totalLineas) {
		this.totalLineas = totalLineas;
	}
	
	public String getSingleNombreFichero(){
		return new File(getNombreFichero()).getName();
	}
	
	public int getLineasOk() {
		return lineasOk;
	}

	public void setLineasOk(int lineasOk) {
		this.lineasOk = lineasOk;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fichero [nombreFichero=");
		builder.append(nombreFichero);
		builder.append(", totalLineas=");
		builder.append(totalLineas);
		builder.append(", lineasOk=");
		builder.append(lineasOk);
		builder.append("]");
		return builder.toString();
	}

	
}

package es.lacaixa.inu.batch.batchcomponentes.bo;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Almacena la información del proceso
 * @author imontesi
 *
 */
public class Proceso {
	/***
	 * Elementos a procesar
	 */
	private List<Fichero> ficheros;
	
	/**
	 * Lineas que han dado fallo
	 */
	private Queue<LineaFichero> lineasKo;
	
	/**
	 * Indica si ha habido algún error en el proceso
	 */
	private boolean errors;

	public Proceso() {
		super();
		ficheros = new LinkedList<Fichero>();
		errors = false;
		lineasKo = new LinkedList<LineaFichero>();
	}

	public List<Fichero> getFicheros() {
		return ficheros;
	}

	public void setFicheros(List<Fichero> ficheros) {
		this.ficheros = ficheros;
	}

	public boolean isErrors() {
		return errors;
	}

	public void setErrors(boolean errors) {
		this.errors = errors;
	}

	public void addError(LineaFichero lf) {
		lineasKo.add(lf);
	}

	public Queue<LineaFichero> getLineasKo() {
		return lineasKo;
	}

	public void setLineasKo(Queue<LineaFichero> lineasKo) {
		this.lineasKo = lineasKo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Proceso [ficheros=");
		builder.append(ficheros);
		builder.append(", lineasKo=");
		builder.append(lineasKo);
		builder.append(", errors=");
		builder.append(errors);
		builder.append("]");
		return builder.toString();
	}
	
	
}

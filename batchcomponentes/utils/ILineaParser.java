package es.lacaixa.inu.batch.batchcomponentes.utils;

import es.lacaixa.inu.batch.batchcomponentes.exception.ParseException;

/**es.lacaixa.inu.batch.cargaComponentes
 * Parsing de líneas
 * @author imontesi
 *
 * @param <T>
 */
public interface ILineaParser<T extends Object> {
	
	/**
	 * Devuelve un {@link T} con los datos de la línea
	 * @param linea
	 * @return
	 * @throws ParseException
	 */
	T parse(String linea) throws ParseException, Exception;
}

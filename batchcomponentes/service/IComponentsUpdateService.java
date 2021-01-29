package es.lacaixa.inu.batch.batchcomponentes.service;

import java.util.List;

import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;

/**
 * Realiza la actualización de componentes en base a la lista de ficheros aptos para
 * ser proceados
 * @author imontesi
 *
 */
public interface IComponentsUpdateService {
	/**
	 * Genera un {@link Proceso} con los resultados del proceso
	 * @param fileNames
	 * @return
	 */
	Proceso updateComponents(List<String> fileNames);
}

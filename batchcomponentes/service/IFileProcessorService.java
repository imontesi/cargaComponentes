package es.lacaixa.inu.batch.batchcomponentes.service;

import es.lacaixa.inu.batch.batchcomponentes.bo.Fichero;
import es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig;
import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;

/**
 * Recibe el {@link Process} y mueve los {@link Fichero} a los directorios
 * adecuados segun el {@link IPathsConfig}
 * @author imontesi
 *
 */
public interface IFileProcessorService {
	
	/**
	 * Mueve los ficheros a los paths adecuados:<br/>
	 * - Si {@link Fichero#getLineasOk()} es 0, se mueve el fichero a {@link IPathsConfig#getError()}<br/>
	 * - Si {@link Fichero#getLineasOk()} es mayor que 0, se mueve el fichero a {@link IPathsConfig#getProcessed()}
	 * @param proceso
	 * @param pathsConfig
	 */
	void mueveFicheros(Proceso proceso, IPathsConfig pathsConfig);
}

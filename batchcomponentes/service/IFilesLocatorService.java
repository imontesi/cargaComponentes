package es.lacaixa.inu.batch.batchcomponentes.service;

import java.util.List;

import es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig;

/**
 * Obtiene un listado de ficheros para procesar
 * @author imontesi
 *
 */
public interface IFilesLocatorService {
	
	/**
	 * Devuelve un listado de ficheros aptos para ser procesados
	 * @param pathsConfig
	 * @return
	 */
	List<String> locateFiles(IPathsConfig pathsConfig);
}

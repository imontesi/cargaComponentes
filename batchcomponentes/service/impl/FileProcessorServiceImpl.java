/**
 * 
 */
package es.lacaixa.inu.batch.batchcomponentes.service.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import es.lacaixa.inu.batch.batchcomponentes.bo.Fichero;
import es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig;
import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;
import es.lacaixa.inu.batch.batchcomponentes.service.IFileProcessorService;
import es.lacaixa.inu.batch.batchcomponentes.utils.FileUtils;

/**
 * @author imontesi
 *
 */
@Service
public class FileProcessorServiceImpl implements IFileProcessorService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessorServiceImpl.class);

	/* (non-Javadoc)
	 * @see es.lacaixa.inu.batch.batchcomponentes.service.IFileProcessor#mueveFicheros(es.lacaixa.inu.batch.batchcomponentes.bo.Proceso, es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig)
	 */
	@Override
	public void mueveFicheros(Proceso proceso, IPathsConfig pathsConfig) {
		for (int i = 0; i < proceso.getFicheros().size(); i++){
			Fichero f = proceso.getFicheros().get(i);
			
			File sourceFile = new File(f.getNombreFichero());
			
			File targetFile = FileUtils.getTargetFile(f, pathsConfig, sourceFile);
			
			try {
				FileUtils.moveFile(sourceFile, targetFile);
				f.setMessage(f.getNombreFichero() + " movido a " + targetFile.getAbsolutePath());
			} catch (Exception e) {
				LOGGER.error("Error moviendo {}:", f.getNombreFichero(), e);
			}
			
		}
	}



}

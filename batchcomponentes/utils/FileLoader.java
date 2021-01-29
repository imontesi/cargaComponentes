package es.lacaixa.inu.batch.batchcomponentes.utils;

import java.io.File;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import es.lacaixa.inu.batch.batchcomponentes.bo.LineaFichero;

/**
 * Carga un fichero, devolviendo un {@link Queue} con las filas leidas
 * @author imontesi
 *
 */
public class FileLoader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileLoader.class);
	
	public static Queue<LineaFichero> loadFile(String fileName){
	
		DefaultLineProcessor dlp = new DefaultLineProcessor();
		
		Queue<LineaFichero> lineasOk = null;
		
		try {
			lineasOk = Files.readLines(new File(fileName), Charsets.UTF_8, dlp);
		}
		catch(Exception e){
			LOGGER.error("Error leyendo {}:", fileName, e);			
		}
		
		
		return lineasOk;
	}
}

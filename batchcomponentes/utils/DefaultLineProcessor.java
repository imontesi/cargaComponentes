package es.lacaixa.inu.batch.batchcomponentes.utils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.LineProcessor;

import es.lacaixa.inu.batch.batchcomponentes.bo.LineaFichero;
import es.lacaixa.inu.batch.batchcomponentes.exception.ParseException;

/**
 * Implementación por defecto de {@link LineProcessor}
 * @author imontesi
 *
 */
public class DefaultLineProcessor implements LineProcessor<Queue<LineaFichero>> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLineProcessor.class);

	private Queue<LineaFichero> lineas = new LinkedList<LineaFichero>();
	
	private DefaultLineaParser dlp = new DefaultLineaParser();
	
	@Override
	public Queue<LineaFichero> getResult() {
		return lineas;
	}
	
	@Override
	public boolean processLine(String arg0) throws IOException {
		LOGGER.trace("processLine('{}')", arg0);
		
		LineaFichero lf = null;
		
		try {
			lf = dlp.parse(arg0);
			
		} catch (ParseException e) {
			LOGGER.warn(e.getMessage());
			
			lf = new LineaFichero();
			lf.setLinea(arg0);
			lf.setMessage(e.getMessage());
			lf.setError(true);
			
		}	catch (Exception e) {
			LOGGER.warn(e.getMessage());
			
			lf = new LineaFichero();
			lf.setLinea(arg0);
			lf.setMessage(e.getMessage());
			lf.setError(true);
			
		}	
		lineas.add(lf);
		
		return true;
	}
}

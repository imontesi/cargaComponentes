package es.lacaixa.inu.batch.batchcomponentes.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;
import es.lacaixa.inu.batch.batchcomponentes.config.PathsConfig;
import es.lacaixa.inu.batch.batchcomponentes.service.IComponentsUpdateService;
import es.lacaixa.inu.batch.batchcomponentes.service.IFileProcessorService;
import es.lacaixa.inu.batch.batchcomponentes.service.IFilesLocatorService;
import es.lacaixa.inu.batch.batchcomponentes.service.INMComponentsService;
import es.lacaixa.inu.batch.batchcomponentes.service.IReportService;

@Service
public class NMComponentsServiceImpl implements INMComponentsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NMComponentsServiceImpl.class);
	
	@Autowired
	private PathsConfig pathsConfig;
	
	@Autowired 
	private IReportService reportService;
	
	@Autowired
	private IFilesLocatorService filesLocatorService;
	
	@Autowired
	private IComponentsUpdateService componentsUpdateService;
	
	@Autowired
	private IFileProcessorService fileProcessorService;
	
	@Override
	public void updateComponents() {
		LOGGER.info("Actualizando componentes...");
		
		/*
		 * Obtención de los ficheros
		 */
		LOGGER.info("Obteniendo ficheros...");
		List<String> files = filesLocatorService.locateFiles(pathsConfig);
		
		if (files == null || files.size() == 0){
			LOGGER.error("No se han encontrado ficheros a procesar");
			return;
		}
		
		/*
		 * Procesado de los ficheros
		 */
		LOGGER.info("Procesando {} ficheros...", files.size());
		Proceso proceso = componentsUpdateService.updateComponents(files);
		
		/*
		 * Movimiento de los ficheros
		 */
		LOGGER.info("Moviendo ficheros...");
		fileProcessorService.mueveFicheros(proceso, pathsConfig);
		
		LOGGER.info("Reportando...");
		reportService.report(proceso);		
	}

}

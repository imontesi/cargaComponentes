package es.lacaixa.inu.batch.batchcomponentes.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig;
import es.lacaixa.inu.batch.batchcomponentes.service.IFilesLocatorService;
import es.lacaixa.inu.batch.batchcomponentes.utils.FileScanner;

@Service
public class FilesLocatorServiceImpl implements IFilesLocatorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FilesLocatorServiceImpl.class);

	@Override
	public List<String> locateFiles(IPathsConfig pathsConfig) {
		LOGGER.info("Buscando ficheros en {}", pathsConfig);
		
		List<String> fileNames = FileScanner.getFileNames(pathsConfig);
		
		return fileNames;
	}

}

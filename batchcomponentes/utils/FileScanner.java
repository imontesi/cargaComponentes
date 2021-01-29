package es.lacaixa.inu.batch.batchcomponentes.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig;

/**
 * Localiza los ficheros en un path
 * @author imontesi
 *
 */
public class FileScanner {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileScanner.class);

	public static List<String> getFileNames(IPathsConfig pathsConfig) {

		LOGGER.debug("Config: {}", pathsConfig);

		File f = new File(pathsConfig.getBasepath() + pathsConfig.getReception());

		File[] ffs = f.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				LOGGER.trace("Testing {}, {}", pathname, pathname.isFile());
				return pathname.isFile();
			}
		});

		LOGGER.trace("Found: {}", (Object[])ffs);
		if(ffs == null){
			LOGGER.warn("No se han encontrado ficheros");
			return null;
		}
		List<String> files = new ArrayList<String>(ffs.length);
		for (int i = 0; i < ffs.length; i++) {
			files.add(ffs[i].getPath());
		}

		LOGGER.debug("To process: {}", files);
		return files;
	}
}

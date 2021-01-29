package es.lacaixa.inu.batch.batchcomponentes.utils;

import java.io.File;
import java.io.IOException;

import com.google.common.io.Files;

import es.lacaixa.inu.batch.batchcomponentes.bo.Fichero;
import es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig;

/**
 * Utilidades con ficheros
 * @author imontesi
 *
 */
public class FileUtils {
	public static final File getTargetFile(Fichero f, IPathsConfig pathsConfig, File sourceFile) {
		StringBuilder sb = getTargetFileString(f, pathsConfig, sourceFile);
		
		return new File(sb.toString());
	}

	public static final  StringBuilder getTargetFileString(Fichero f, IPathsConfig pathsConfig, File sourceFile) {
		StringBuilder sb = new StringBuilder();
		sb.append(pathsConfig.getBasepath());
		if(f.getLineasOk() == 0){
			sb.append(pathsConfig.getError());
		}
		else{
			sb.append(pathsConfig.getProcessed());
		}
		sb.append("/");
		sb.append(sourceFile.getName());
		return sb;
	}

	public static void moveFile(File sourceFile, File targetFile) throws IOException {
		Files.move(sourceFile, targetFile);		
	}
}

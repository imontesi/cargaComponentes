package es.lacaixa.inu.batch.batchcomponentes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import es.lacaixa.inu.batch.batchcomponentes.bo.IPathsConfig;


/**
 * Configuración de paths
 * @author imontesi
 *
 */
@Configuration
@ConfigurationProperties(prefix = "app.config.paths")
public class PathsConfig implements IPathsConfig {
	private String basepath;
	private String reception;
	private String error;
	private String processed;
	
	/* (non-Javadoc)
	 * @see es.lacaixa.inu.batch.batchcomponentes.config.IPathsConfig#getBasepath()
	 */
	@Override
	public String getBasepath() {
		return basepath;
	}
	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}
	/* (non-Javadoc)
	 * @see es.lacaixa.inu.batch.batchcomponentes.config.IPathsConfig#getReception()
	 */
	@Override
	public String getReception() {
		return reception;
	}
	public void setReception(String reception) {
		this.reception = reception;
	}
	@Override
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	/* (non-Javadoc)
	 * @see es.lacaixa.inu.batch.batchcomponentes.config.IPathsConfig#getProcessed()
	 */
	@Override
	public String getProcessed() {
		return processed;
	}
	public void setProcessed(String processed) {
		this.processed = processed;
	}
	@Override
	public String toString() {
		return "PathsConfig [basepath=" + basepath + ", reception=" + reception + ", error=" + error + ", processed="
				+ processed + "]";
	}
	
	
}

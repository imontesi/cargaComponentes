package es.lacaixa.inu.batch.batchcomponentes.bo;

/**
 * Abstracción para representar configuración sobre los paths de trabajo
 * @author imontesi
 *
 */
public interface IPathsConfig {

	String getBasepath();

	String getReception();

	String getProcessed();

	String getError();

}
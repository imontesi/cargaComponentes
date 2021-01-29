package es.lacaixa.inu.batch.batchcomponentes.service;

import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;

/**
 * Reporting del resultado del proceso
 * @author imontesi
 *
 */
public interface IReportService {
	
	/**
	 * Realiza el reporting
	 * @param proceso
	 */
	void report(Proceso  proceso);
}

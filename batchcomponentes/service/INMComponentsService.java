package es.lacaixa.inu.batch.batchcomponentes.service;

/**
 * Servicio para la ejecución del proceso
 * @author imontesi
 *
 */
public interface INMComponentsService {
	
	/**
	 * Ejecuta el proceso
	 * - Recupera la lista de ficheros a procesar
	 * - Obtiene y parsea las líneas en cada fichero
	 * - Verifica que exista un componente a partir del campo PK
	 * - Verifica que el componente no se haya actualizado más recientemente
	 * - Verifica que el centro y empresa existan
	 * - Actualiza el componente
	 * - Mueve los ficheros según el estado
	 * - Envia un mail con el resultado
	 */
	void updateComponents();
}

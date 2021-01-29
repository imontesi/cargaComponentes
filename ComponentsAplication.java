package es.lacaixa.inu.batch.batchcomponentes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import es.lacaixa.inu.batch.batchcomponentes.service.INMComponentsService;

/**
 * Clase principal
 * 
 * @author imontesi
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={
		"es.lacaixa.inu.batch.batchcomponentes.config",
		"es.lacaixa.inu.batch.batchcomponentes.entity",
		"es.lacaixa.inu.batch.batchcomponentes.dao",
		"es.lacaixa.inu.batch.batchcomponentes.service"
})
@EntityScan(
		basePackages={
				"es.lacaixa.inu.batch.batchcomponentes.entity"
})
@EnableCaching
//@EnableJpaRepositories("es.uc3m.tiw.dominios")
public class ComponentsAplication implements CommandLineRunner{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsAplication.class);
	
	/**
	 * Servicio de ejecuciÃ³n
	 */
	@Autowired
	private INMComponentsService componentsService;

	/**
	 * Lanza la aplicaciÃ³n
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ComponentsAplication.class, args);
	}

	/**
	 * Ejecuta la aplicaciÃ³n
	 */
	@Override
	public void run(String... args0) throws Exception {
		LOGGER.info("Components :: run");
		
		componentsService.updateComponents();
	}
}

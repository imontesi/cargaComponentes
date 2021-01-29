package es.lacaixa.inu.batch.batchcomponentes.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.lacaixa.inu.batch.batchcomponentes.entity.ComponentEntity;
import es.lacaixa.inu.batch.batchcomponentes.entity.ComponentKey;

/**
 * {@link JpaRepository} para las operativas con {@link ComponentEntity}
 * @author imontesi
 *
 */

@CacheConfig(cacheNames="componentes")
@Transactional(readOnly=true)
@Repository
public interface IComponentsDAO extends JpaRepository<ComponentEntity, ComponentKey>{

	@Cacheable(key="#root.methodName + #p0")
	List<ComponentEntity> findByFamiliaAndMarcaAndTipoAndModelAndNumeroSerie(String familia, String marca,String tipo, String model, String numeroSerie);

	/**
	 * Se sobreescribe para realizar limpieza de cache ante cualquier cambio,
	 * así como para poder gestionar su transaccionalidad
	 */
	@Modifying()
	@Transactional
	@Override
	@CacheEvict(cacheNames="componentes", allEntries=true)
	<S extends ComponentEntity> S save(S entity);	
	<S extends ComponentKey> S delete(S ComponentKey);
	
}

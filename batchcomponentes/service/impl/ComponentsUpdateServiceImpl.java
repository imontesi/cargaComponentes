package es.lacaixa.inu.batch.batchcomponentes.service.impl;

import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.lacaixa.inu.batch.batchcomponentes.bo.Fichero;
import es.lacaixa.inu.batch.batchcomponentes.bo.LineaFichero;
import es.lacaixa.inu.batch.batchcomponentes.bo.Proceso;
import es.lacaixa.inu.batch.batchcomponentes.dao.IComponentsDAO;
import es.lacaixa.inu.batch.batchcomponentes.entity.ComponentEntity;
import es.lacaixa.inu.batch.batchcomponentes.exception.LogicException;
import es.lacaixa.inu.batch.batchcomponentes.service.IComponentsUpdateService;
import es.lacaixa.inu.batch.batchcomponentes.utils.FileLoader;

@Service
public class ComponentsUpdateServiceImpl implements IComponentsUpdateService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsUpdateServiceImpl.class);
	
	@Autowired
	private IComponentsDAO componentsDAO;

	@Override
	public Proceso updateComponents(List<String> fileNames) {
		LOGGER.info("Ejecutando actualización de componentes");
		
		Proceso proceso = new Proceso();
		
		for (int i = 0; i < fileNames.size(); i++){
			LOGGER.debug("Procesando {}", fileNames.get(i));
			
			/*
			 * Carga del contenido del fichero
			 */
			Queue<LineaFichero> lineas = FileLoader.loadFile(fileNames.get(i));
			
			/*
			 * Creación del objeto Fichero
			 */
			Fichero f = new Fichero();
			f.setNombreFichero(fileNames.get(i));
			f.setTotalLineas(lineas == null ? 0 : lineas.size());			
			
			/*
			 * Si no hay lineas, se ignora
			 */
			if (f.getTotalLineas() == 0){
				LOGGER.error("Error, fichero {} no contiene ninguna línea válida", f.getNombreFichero());
			}			
			else{
				
				procesaFichero (proceso, f, lineas);
				
				LOGGER.debug("Resultado: {}", f);
			}
			
			proceso.getFicheros().add(f);			

		}		
		
		return proceso;
	}

	/**
	 * Procesa el fichero
	 * @param proceso
	 * @param f
	 * @param lineas
	 */
	private void procesaFichero(Proceso proceso, Fichero f, Queue<LineaFichero> lineas) {
		LOGGER.info("Procesando {}\n - Lineas: {}", f.getNombreFichero(), lineas.size());
		
		LineaFichero lf = null;
		while ( (lf = lineas.poll()) != null){
			LOGGER.trace("Proceando linea {}", lf);
			
			if (lf.isError()){
				LOGGER.trace("Linea {} con error", lf);
				proceso.addError(lf);
			}
			else{			
				ComponentEntity ce = null;
				try {
					LOGGER.trace("Buscando componente para {}", lf);

					List<ComponentEntity> cs = null;
					
					try{
						LOGGER.trace("findByfamilia({})", lf.getFamilia());
						cs = componentsDAO.findByFamiliaAndMarcaAndTipoAndModelAndNumeroSerie(lf.getFamilia(),lf.getMarca(),lf.getTipo(), lf.getModel(), lf.getNumeroSerie());
					}
					
					catch (Exception e) {
						LOGGER.error("Error consultando DB", e);
						throw new LogicException("Error consultando DB para el centro: " + lf.getCentro() + e.getMessage());
					}
					
					if (cs == null || cs.size() == 0){
						LOGGER.info("No se encuentra componente. Se da de alta en la bbdd", lf.getCentro());
						processComponent(lf, ce);
					}
					
					if (cs.size() == 1){
						LOGGER.warn("Un componente encontrado para {}. se actualiza el valor en bbdd",  lf);
						cs.remove(0);
						processComponent(lf, ce);
					}

					f.setLineasOk(f.getLineasOk() + 1);
				} catch (LogicException e) {
					LOGGER.error("Error procesando {}:", lf, e);
					
					lf.setMessage(e.getMessage());
					proceso.addError(lf);
					
				}
			}
		}
	}

	/**
	 * Procesa un componente
	 * @param lf
	 * @param ce
	 * @throws LogicException
	 */
	private void processComponent(LineaFichero lf, ComponentEntity ca) throws LogicException {

		/*
		 * Actualización del componente
		 */
		ComponentEntity ce =new ComponentEntity();
		ce.setCentro(lf.getCentro());
		ce.setEmpresa(lf.getEmpresa());
		ce.setCentroFact(lf.getCentro());
		//ce.setEmpresaFact(lf.getEmpresa());
		
		
		ce.setAltaCaixa(lf.getAltaCaixa());
		ce.setAñoFacturacion(lf.getAñoFacturacion());
		ce.setCentro(lf.getCentro());
		ce.setCentroAnterior(lf.getCentroAnterior());
		ce.setCentroDesplacat(lf.getCentroDesplacat());
		ce.setCentroFact(lf.getCentroFact());
		ce.setClient(lf.getClient());
		ce.setCodigoEmpresaMantenimineto(lf.getCodigoEmpresaMantenimineto());
		ce.setComentario(lf.getComentario());
		ce.setContrato(lf.getContrato());
		ce.setEmpresa(lf.getEmpresa());
		ce.setEmpresaFact(lf.getEmpresaFact());
		ce.setFamilia(lf.getFamilia());
		ce.setFechaActualizacionComponente(lf.getFechaActualizacionComponente());
		ce.setFechaAltaInstalacion(lf.getFechaAltaInstalacion());
		ce.setFechaBaja(lf.getFechaBaja());
		ce.setFechaContratacion(lf.getFechaContratacion());
		ce.setFechaFactura(lf.getFechaFactura());
		ce.setFechaFinGarantia(lf.getFechaFinGarantia());
		ce.setFechaInicioGarantia(lf.getFechaInicioGarantia());
		ce.setFechaInstalacion(lf.getFechaInstalacion());
		ce.setHostName(lf.getHostName());
		ce.setLineaFactura(lf.getLineaFactura());
		ce.setMarca(lf.getMarca());
		ce.setMatricula(lf.getMatricula());
		ce.setMatriculaComponente(lf.getMatriculaComponente());
		ce.setMatriculaContenido(lf.getMatriculaContenido());
		ce.setModel(lf.getModel());
		ce.setNm(lf.getNm());
		ce.setNumeroSerie(lf.getNumeroSerie());
		ce.setNumeroSerieFabricante(lf.getNumeroSerieFabricante());
		ce.setObservacion(lf.getObservacion());
		ce.setPlanta(lf.getPlanta());
		ce.setProveedor(lf.getProveedor());
		ce.setReferenciaFactura(lf.getReferenciaFactura());
		ce.setRfid(lf.getRfid());
		ce.setTipo(lf.getTipo());
		
		if(lf.getMatricula()!=null) {
			LOGGER.trace("Actualizando matricula {} en componenten {}", lf.getMatricula(), ce);
			ce.setMatricula(lf.getMatricula());
		}
		
		try{
			ce = componentsDAO.save(ce);
			
			LOGGER.trace("Actualizado {}", ce);
		}
		catch (Exception e) {
			LOGGER.error("Error actualizando componente {}:", ce, e);
			throw new LogicException("Error actualizando componente");
		}
		
	}	
}

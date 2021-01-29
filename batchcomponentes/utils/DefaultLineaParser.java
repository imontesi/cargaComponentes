package es.lacaixa.inu.batch.batchcomponentes.utils;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.lacaixa.inu.batch.batchcomponentes.bo.LineaFichero;
import es.lacaixa.inu.batch.batchcomponentes.exception.ParseException;

import java.text.SimpleDateFormat;  
import java.util.Date; 
/**
 * Implementación por defecto de {@link ILineaParser}
 * @author imontesi
 *
 */
public class DefaultLineaParser implements ILineaParser<LineaFichero> {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLineaParser.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private String lpad(String cad, int zeroes) {
		return StringUtils.leftPad(cad, zeroes, "0");
	}

	@Override
	public LineaFichero parse(String linea) throws ParseException, Exception {
		LOGGER.info("Parsing: '{}'", linea);
		if (linea == null || linea.length() != 433){
			LOGGER.warn("Linea '{}' errónea", linea);
			throw new ParseException("Formato incorrecto, longitud de linea: "+linea.length());
		}
		
		LineaFichero lf = new LineaFichero();
		lf.setLinea(linea);

		LOGGER.trace("Processing '{}'", linea);

		String[] parts = new String[40];
//		if (parts.length != 5){
//			LOGGER.warn("Linea '{}' erronea, no tiene el numero de tokens requerido, se ha enontrado {}", linea, parts);
//			throw new ParseException("Formato incorrecto, se requiere '#PK;EMPRESA;CENTRO;FECHA;MATRICULA#'");
//		}
		
		parts[0]= linea.substring(0,4); //COM_FAMILIA
		lf.setFamilia(parts[0]);
		parts[1]= linea.substring(4,8); //COM_MARCA
		lf.setMarca(parts[1]);
		parts[2]= linea.substring(8,12); //COM_TIPO
		lf.setTipo(parts[2]);
		parts[3]= linea.substring(12,16); //COM_MODEL
		lf.setModel(parts[3]);
		parts[4]= linea.substring(16,21); //COM_EMPR
		lf.setEmpresa(parts[4]);
		parts[5]= linea.substring(21,26); //COM_CEN
		lf.setCentro(parts[5]);
		parts[6]= linea.substring(26,29); //COM_PLANTA
		lf.setPlanta(parts[6]);
		parts[7]= linea.substring(29,39); //COM_DATA_INSTALACIO
		if (parts[7].trim()!="" && parts[7].trim().length()==10){
			Date fechaInstalacion= new SimpleDateFormat("dd/MM/yyyy").parse(parts[7]);
			lf.setFechaInstalacion(fechaInstalacion);	
		}
		parts[8]= linea.substring(39,44); //COM_CEN_DESPLACAT
		lf.setCentroDesplacat(parts[8]);
		parts[9]= linea.substring(44,58); //COM_NUMERO_SERIE
		lf.setNumeroSerie(parts[9]);
		parts[10]= linea.substring(58,65); //COM_MATRICULA
		if (parts[10].trim()!="")
			lf.setMatriculaComponente(parts[10]);
		parts[11]= linea.substring(65,72); //COM_NMCAIXA
		if (parts[11].trim()!="")
			lf.setNm(parts[11]);
		parts[12]= linea.substring(72,82); //COM_ALTACAIXA
		if (parts[12].trim()!="" && parts[12].trim().length()==10){
			Date fechaAltaCaixa = new SimpleDateFormat("dd/MM/yyyy").parse(parts[12]);
			lf.setAltaCaixa(fechaAltaCaixa);			
		}
		parts[13]= linea.substring(82,90); //COM_CONTRACTE
		lf.setContrato(parts[13]);
		parts[14]= linea.substring(90,109); //COM_PROVEIDOR
		lf.setProveedor(parts[14]);
		parts[15]= linea.substring(109,124); //COM_FACTURA
		lf.setReferenciaFactura(parts[15]);
		parts[16]= linea.substring(124,134); //COM_LINFACTURA
		if(parts[16].trim()!="") {
			lf.setLineaFactura(parts[16].trim());
		}
		parts[17]= linea.substring(134,144); //COM_INIGARANTIA
		if (parts[17].trim()!="" && parts[17].trim().length()==10){
			Date fechaInicioGarantia = new SimpleDateFormat("dd/MM/yyyy").parse(parts[17]);
			lf.setFechaInicioGarantia(fechaInicioGarantia);			
		}
		parts[18]= linea.substring(144,154); //COM_FIGARANTIA
		if (parts[18].trim()!="" && parts[18].trim().length()==10){
			Date fechaFinGarantia = new SimpleDateFormat("dd/MM/yyyy").parse(parts[18]);
			lf.setFechaFinGarantia(fechaFinGarantia);			
		}
		parts[19]= linea.substring(154,164); //COM_BAIXACAIXA
		if (parts[19].trim()!="" && parts[19].trim().length()==10){
			Date fechaBaja = new SimpleDateFormat("dd/MM/yyyy").parse(parts[19]);
			lf.setFechaBaja(fechaBaja);	
		}
		parts[20]= linea.substring(164,171); //COM_EMPMANTENIM
		if(parts[20].trim()!="") {
			lf.setCodigoEmpresaMantenimineto( parts[20].trim());
		}
		parts[21]= linea.substring(171,181); //COM_ACENTRE
		if (parts[21].trim()!="" && parts[21].trim().length()==10){
			Date fechaActualizacionComponente = new SimpleDateFormat("dd/MM/yyyy").parse(parts[21]);
			lf.setFechaActualizacionComponente(fechaActualizacionComponente);			
		}
		parts[22]= linea.substring(181,188); //COM_MATCONTINGUT
		lf.setMatriculaContenido(parts[22]);
		parts[23]= linea.substring(188,198); //COM_DATAFACTURA
		if (parts[23].trim()!="" && parts[23].trim().length()==10){
			Date fechaFactura = new SimpleDateFormat("dd/MM/yyyy").parse(parts[23]);
			lf.setFechaFactura(fechaFactura);			
		}
		parts[24]= linea.substring(198,228); //COM_SERIE_FABRICANT
		lf.setNumeroSerieFabricante(parts[24]);
		parts[25]= linea.substring(228,278); //COM_OBSERVACIO
		lf.setObservacion(parts[25]);
		parts[26]= linea.substring(278,282); //COM_FUNCIO
		
		parts[27]= linea.substring(282,287); //COM_EMPFACT
		lf.setEmpresaFact(parts[27]);
		parts[28]= linea.substring(287,292); //COM_CENTREFACT
		lf.setCentroFact(parts[28]);
		parts[29]= linea.substring(292,296); //COM_ANYFACT
		if(parts[29].trim()!="") {
			lf.setAñoFacturacion( parts[29].trim());
		}
		parts[30]= linea.substring(296,306); //COM_INIINSTAL
		if (parts[30].trim()!="" && parts[30].trim().length()==10){
			Date fechaAltaInst = new SimpleDateFormat("dd/MM/yyyy").parse(parts[30]);
			lf.setFechaAltaInstalacion(fechaAltaInst);		
		}
		parts[31]= linea.substring(306,336); //COM_COMENTARI
		lf.setComentario(parts[31]);
		parts[32]= linea.substring(336,353); //TLF_IMEI
		
		parts[33]= linea.substring(353,364); //TLF_PUK
		
		parts[34]= linea.substring(362,367); //COM_CLIENT
		lf.setClient(parts[34]);
		//TODO en bbdd son 8 posiciones en vez de 11
		parts[35]= linea.substring(367,373); //USU_MATRICULA
		lf.setMatricula(parts[35]);
		parts[36]= linea.substring(378,388); //COM_CONTRATACIO
		if (parts[36].trim()!="" && parts[36].trim().length()==10){
			Date fechaContratacion = new SimpleDateFormat("dd/MM/yyyy").parse(parts[36]);
			lf.setFechaContratacion(fechaContratacion);			
		}
		// TODO de momento se comenta ya q el fichero eviado se envían 400 posiciones y no 436
		parts[37]= linea.substring(388,398); //COM_HOSTNAME
		lf.setHostName(parts[37]);
		parts[38]= linea.substring(398,403); //COM_CEN_ANTERIOR
		lf.setCentroAnterior(parts[38]);
		parts[39]= linea.substring(403,432); //COM_RFID
		lf.setRfid(parts[39]);

		lf.setMessage("");
		
		if (parts[0] == null || parts[0].length() == 0){
			LOGGER.warn("Linea '{}' erronea, token 'pk' incorrecto {}", linea, parts[0]);
			throw new ParseException("Formato incorrecto, falta 'PK'");			
		}

		if (lf.getFamilia().trim()=="" || lf.getFamilia()==null){
			LOGGER.warn("Linea '{}' erronea, falta campo PK Familia ", linea);
			throw new ParseException("Formato incorrecto, falta campo PK Familia");			
		}
		if (lf.getMarca().trim()=="" || lf.getMarca()==null){
			LOGGER.warn("Linea '{}' erronea, falta campo PK Marca ", linea);
			throw new ParseException("Formato incorrecto, falta campo PK Marca");			
		}		
		if (lf.getTipo().trim()=="" || lf.getTipo()==null){
			LOGGER.warn("Linea '{}' erronea, falta campo PK Tipo ", linea);
			throw new ParseException("Formato incorrecto, falta campo PK Tipo");			
		}
		if (lf.getModel().trim()=="" || lf.getModel()==null){
			LOGGER.warn("Linea '{}' erronea, falta campo PK Model ", linea);
			throw new ParseException("Formato incorrecto, falta campo PK Model");			
		}
		if (lf.getNumeroSerie().trim()=="" || lf.getNumeroSerie()==null){
			LOGGER.warn("Linea '{}' erronea, falta campo PK NumeroSerie ", linea);
			throw new ParseException("Formato incorrecto, falta campo PK NumeroSerie");			
		}	

		LOGGER.trace("Linea procesada: {}", lf);
		
		return lf;
	}

}

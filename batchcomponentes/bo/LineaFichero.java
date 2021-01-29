package es.lacaixa.inu.batch.batchcomponentes.bo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Representa una línea de un fichero
 * @author imontesi
 *
 */
public class LineaFichero extends Reportable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4598031907387400530L;

	private String linea;

	private String familia;
	private String marca;
	private String tipo;
	private String model;
	private String numeroSerie;
	private String matriculaComponente;
	private String nm;
	private String rfid;
	private String client;
	private String empresa;
	private String centro;
	private String planta;
	private String centroDesplacat;
	private Date   altaCaixa;
	private Date   fechaAltaInstalacion;	
	private Date   fechaInstalacion;	
	private Date   fechaBaja;
	private String contrato;
	private Date   fechaContratacion;
	private String proveedor;
	private String añoFacturacion;
	private String referenciaFactura;	
	private String lineaFactura;	
	private Date   fechaFactura;	
	private String numeroSerieFabricante;
	private Date   fechaInicioGarantia;
	private Date   fechaFinGarantia;
	private String codigoEmpresaMantenimineto;
	private String matriculaContenido;
	private String observacion;	
	private String comentario;	
	private String centroAnterior;
	private String hostName;
	private String empresaFact;
	private String centroFact;
	private String matricula;
	private Date   fechaActualizacionComponente;
	
	public Date getFechaActualizacionComponente() {
		return fechaActualizacionComponente;
	}

	public void setFechaActualizacionComponente(Date fechaActualizacionComponente) {
		this.fechaActualizacionComponente = fechaActualizacionComponente;
	}
	private boolean error;
	
	
	
	public LineaFichero() {
		super();
		
		error = false;
	}
	
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getMatriculaComponente() {
		return matriculaComponente;
	}
	public void setMatriculaComponente(String matriculaComponente) {
		this.matriculaComponente = matriculaComponente;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getPlanta() {
		return planta;
	}
	public void setPlanta(String planta) {
		this.planta = planta;
	}
	public String getCentroDesplacat() {
		return centroDesplacat;
	}
	public void setCentroDesplacat(String centroDesplacat) {
		this.centroDesplacat = centroDesplacat;
	}
	public Date getAltaCaixa() {
		return altaCaixa;
	}
	public void setAltaCaixa(Date altaCaixa) {
		this.altaCaixa = altaCaixa;
	}
	public Date getFechaAltaInstalacion() {
		return fechaAltaInstalacion;
	}
	public void setFechaAltaInstalacion(Date fechaAltaInstalacion) {
		this.fechaAltaInstalacion = fechaAltaInstalacion;
	}
	public Date getFechaInstalacion() {
		return fechaInstalacion;
	}
	public void setFechaInstalacion(Date fechaInstalacion) {
		this.fechaInstalacion = fechaInstalacion;
	}
	public Date getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public Date getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getAñoFacturacion() {
		return añoFacturacion;
	}
	public void setAñoFacturacion(String añoFacturacion) {
		this.añoFacturacion = añoFacturacion;
	}
	public String getReferenciaFactura() {
		return referenciaFactura;
	}
	public void setReferenciaFactura(String referenciaFactura) {
		this.referenciaFactura = referenciaFactura;
	}
	public String getLineaFactura() {
		return lineaFactura;
	}
	public void setLineaFactura(String lineaFactura) {
		this.lineaFactura = lineaFactura;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public String getNumeroSerieFabricante() {
		return numeroSerieFabricante;
	}
	public void setNumeroSerieFabricante(String numeroSerieFabricante) {
		this.numeroSerieFabricante = numeroSerieFabricante;
	}
	public Date getFechaInicioGarantia() {
		return fechaInicioGarantia;
	}
	public void setFechaInicioGarantia(Date fechaInicioGarantia) {
		this.fechaInicioGarantia = fechaInicioGarantia;
	}
	public Date getFechaFinGarantia() {
		return fechaFinGarantia;
	}
	public void setFechaFinGarantia(Date fechaFinGarantia) {
		this.fechaFinGarantia = fechaFinGarantia;
	}
	public String getCodigoEmpresaMantenimineto() {
		return codigoEmpresaMantenimineto;
	}
	public void setCodigoEmpresaMantenimineto(String codigoEmpresaMantenimineto) {
		this.codigoEmpresaMantenimineto = codigoEmpresaMantenimineto;
	}
	public String getMatriculaContenido() {
		return matriculaContenido;
	}
	public void setMatriculaContenido(String matriculaContenido) {
		this.matriculaContenido = matriculaContenido;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getCentroAnterior() {
		return centroAnterior;
	}
	public void setCentroAnterior(String centroAnterior) {
		this.centroAnterior = centroAnterior;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getEmpresaFact() {
		return empresaFact;
	}
	public void setEmpresaFact(String empresaFact) {
		this.empresaFact = empresaFact;
	}
	public String getCentroFact() {
		return centroFact;
	}
	public void setCentroFact(String centroFact) {
		this.centroFact = centroFact;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LineaFichero [linea=");
		builder.append(linea);
		builder.append(", familia=");
		builder.append(familia);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", model=");
		builder.append(model);
		builder.append(", numero serie=");
		builder.append(numeroSerie);
		builder.append(", error=");
		builder.append(error);
		builder.append("]");
		return builder.toString();
	}
}

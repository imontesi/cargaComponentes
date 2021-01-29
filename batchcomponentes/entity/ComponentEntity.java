package es.lacaixa.inu.batch.batchcomponentes.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * {@link Entity} que representa un componente
 * @author imontesi
 *
 */
@Entity(name="Components")
@Table(name="INU_COMPONENTS")
@IdClass(ComponentKey.class)
public class ComponentEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7645671063303733890L;

	@Id
	@Column(name="COM_FAMILIA", columnDefinition="nvarchar2")
	private String familia;
	
	@Id
	@Column(name="COM_MARCA", columnDefinition="nvarchar2")
	private String marca;
	
	@Id
	@Column(name="COM_TIPO", columnDefinition="nvarchar2")
	private String tipo;
	
	@Id
	@Column(name="COM_MODEL", columnDefinition="nvarchar2")
	private String model;
	
	@Id
	@Column(name="COM_NUMERO_SERIE", columnDefinition="nvarchar2")
	private String numeroSerie;
	
	@Column(name="COM_MATRICULA", columnDefinition="nvarchar2")
	private String matriculaComponente;
		
	@Column(name="COM_NMCAIXA", columnDefinition="nvarchar2", nullable=true)
	private String nm;
	
	@Column(name="COM_RFID", columnDefinition="nvarchar2", nullable=true)
	private String rfid;

	@Column(name="COM_CLIENT", columnDefinition="nvarchar2", nullable=true)
	private String client;

	@Column(name="COM_EMPR", columnDefinition="nvarchar2", nullable=true)
	private String empresa;

	@Column(name="COM_CEN", columnDefinition="nvarchar2", nullable=true)
	private String centro;
	
	@Column(name="COM_PLANTA", columnDefinition="nvarchar2", nullable=true)
	private String planta;
	
	@Column(name="COM_CEN_DESPLACAT", columnDefinition="nvarchar2", nullable=true)
	private String centroDesplacat;

	@Column(name="COM_ALTACAIXA", columnDefinition="date", nullable=true)
	private Date altaCaixa;
	
	@Column(name="COM_INIINSTAL", columnDefinition="date", nullable=true)
	private Date fechaAltaInstalacion;	
	
	@Column(name="COM_DATA_INSTALACIO", columnDefinition="date", nullable=true)
	private Date fechaInstalacion;	
	
	@Column(name="COM_BAIXACAIXA", columnDefinition="date", nullable=true)
	private Date fechaBaja;

	@Column(name="COM_CONTRACTE", columnDefinition="nvarchar2", nullable=true)
	private String contrato;
	
	@Column(name="COM_CONTRACTACIO", columnDefinition="date", nullable=true)
	private Date fechaContratacion;
	
	@Column(name="COM_PROVEIDOR", columnDefinition="nvarchar2", nullable=true)
	private String proveedor;
	
	@Column(name="COM_ANYFACT", columnDefinition="number", nullable=true)
	private String añoFacturacion;

	@Column(name="COM_FACTURA", columnDefinition="nvarchar2", nullable=true)
	private String referenciaFactura;	
	
	@Column(name="COM_LINFACTURA", columnDefinition="number", nullable=true)
	private String lineaFactura;	
	
	@Column(name="COM_DATAFACTURA", columnDefinition="date", nullable=true)
	private Date fechaFactura;	
	
	@Column(name="COM_SERIE_FABRICANT", columnDefinition="nvarchar2", nullable=true)
	private String numeroSerieFabricante;
	
	@Column(name="COM_INIGARANTIA", columnDefinition="date", nullable=true)
	private Date fechaInicioGarantia;
	
	@Column(name="COM_FIGARANTIA", columnDefinition="date", nullable=true)
	private Date fechaFinGarantia;
	
	@Column(name="COM_EMPMANTENIM", columnDefinition="number", nullable=true)
	private String codigoEmpresaMantenimineto;
	
	@Column(name="COM_MATCONTINGUT", columnDefinition="nvarchar2", nullable=true)
	private String matriculaContenido;
	
	@Column(name="COM_OBSERVACIO", columnDefinition="nvarchar2", nullable=true)
	private String observacion;	
	
	@Column(name="COM_COMENTARI", columnDefinition="nvarchar2", nullable=true)
	private String comentario;	
	
	@Column(name="COM_CEN_ANTERIOR", columnDefinition="nvarchar2", nullable=true)
	private String centroAnterior;
	
	@Column(name="COM_HOSTNAME", columnDefinition="nvarchar2", nullable=true)
	private String hostName;

	@Column(name="COM_EMPFACT", columnDefinition="nvarchar2", nullable=true)
	private String empresaFact;
	
	@Column(name="COM_CENTREFACT", columnDefinition="nvarchar2", nullable=true)
	private String centroFact;
	
	@Column(name="COM_ACENTRE", columnDefinition="date", nullable=true)
	private Date fechaActualizacionComponente;
	
	@Column(name="COM_EMPL_MATRICULA", columnDefinition="nvarchar2", nullable=true)
	private String matricula;

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
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

	public Date getFechaActualizacionComponente() {
		return fechaActualizacionComponente;
	}

	public void setFechaActualizacionComponente(Date fechaActualizacionComponente) {
		this.fechaActualizacionComponente = fechaActualizacionComponente;
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

//	public EmpresesEntity getEmpresaJoin() {
//		return empresaJoin;
//	}
//
//	public void setEmpresaJoin(EmpresesEntity empresaJoin) {
//		this.empresaJoin = empresaJoin;
//	}

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
	public String getMatriculaComponente() {
		return matriculaComponente;
	}

	public void setMatriculaComponente(String matriculaComponente) {
		this.matriculaComponente = matriculaComponente;
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


	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public String getReferenciaFactura() {
		return referenciaFactura;
	}

	public void setReferenciaFactura(String referenciaFactura) {
		this.referenciaFactura = referenciaFactura;
	}


	public String getNumeroSerieFabricante() {
		return numeroSerieFabricante;
	}

	public void setNumeroSerieFabricante(String numeroSerieFabricante) {
		this.numeroSerieFabricante = numeroSerieFabricante;
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
	

	public String getAñoFacturacion() {
		return añoFacturacion;
	}

	public void setAñoFacturacion(String añoFacturacion) {
		this.añoFacturacion = añoFacturacion;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComponentEntity [familia=");
		builder.append(familia);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", model=");
		builder.append(model);
		builder.append(", numeroSerie=");
		builder.append(numeroSerie);
		builder.append(", nm=");
		builder.append(nm);
		builder.append(", rfid=");
		builder.append(rfid);
		builder.append(", client=");
		builder.append(client);
		builder.append(", empresa=");
		builder.append(empresa);
		builder.append(", centro=");
		builder.append(centro);
		builder.append(", empresaFact=");
		builder.append(empresaFact);
		builder.append(", centroFact=");
		builder.append(centroFact);
		builder.append(", fechaActualizacionComponente=");
		//builder.append(fechaActualizacionComponente);
		builder.append(", matricula=");
		builder.append(matricula);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centro == null) ? 0 : centro.hashCode());
		result = prime * result + ((centroFact == null) ? 0 : centroFact.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((empresaFact == null) ? 0 : empresaFact.hashCode());
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		//result = prime * result + ((fechaActualizacionComponente == null) ? 0 : fechaActualizacionComponente.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((nm == null) ? 0 : nm.hashCode());
		result = prime * result + ((numeroSerie == null) ? 0 : numeroSerie.hashCode());
		result = prime * result + ((rfid == null) ? 0 : rfid.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentEntity other = (ComponentEntity) obj;
		if (centro == null) {
			if (other.centro != null)
				return false;
		} else if (!centro.equals(other.centro))
			return false;
		if (centroFact == null) {
			if (other.centroFact != null)
				return false;
		} else if (!centroFact.equals(other.centroFact))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (empresaFact == null) {
			if (other.empresaFact != null)
				return false;
		} else if (!empresaFact.equals(other.empresaFact))
			return false;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
//		if (fechaActualizacionComponente == null) {
//			if (other.fechaActualizacionComponente != null)
//				return false;
//		} else if (!fechaActualizacionComponente.equals(other.fechaActualizacionComponente))
//			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (nm == null) {
			if (other.nm != null)
				return false;
		} else if (!nm.equals(other.nm))
			return false;
		if (numeroSerie == null) {
			if (other.numeroSerie != null)
				return false;
		} else if (!numeroSerie.equals(other.numeroSerie))
			return false;
		if (rfid == null) {
			if (other.rfid != null)
				return false;
		} else if (!rfid.equals(other.rfid))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	
}

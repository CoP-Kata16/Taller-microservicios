package com.microservice.createnotification.pojo;

public class FilterConfiguration {
	private String referencia;
	
	private String usuario;
	
	private Integer tipoAlerta;

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the tipoAlerta
	 */
	public Integer getTipoAlerta() {
		return tipoAlerta;
	}

	/**
	 * @param tipoAlerta the tipoAlerta to set
	 */
	public void setTipoAlerta(Integer tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}
	
	
	
}

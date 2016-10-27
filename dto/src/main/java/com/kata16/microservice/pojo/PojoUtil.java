package com.kata16.microservice.pojo;

public class PojoUtil {

	public static FilterConfiguration createFilterConfiguration(final Configuracion configuracion) {
		FilterConfiguration filter = new FilterConfiguration();
		filter.setReference(configuracion.getReferencia());
		filter.setTipoAlerta(configuracion.getTipoAlerta());
		filter.setUser(configuracion.getUsuario());
		return filter;
	}
}

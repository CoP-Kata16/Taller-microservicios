package com.microservice.configurationuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.configurationuser.pojo.Configuracion;
import com.microservice.configurationuser.pojo.FilterConfiguration;
import com.microservice.configurationuser.repository.ConfigurationRepository;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

	@Autowired
	ConfigurationRepository configurationRepository;
	
	@RequestMapping("/create")
	public Configuracion create(@RequestBody Configuracion configuracion)
	{
		Configuracion cfg = this.findByReferenceUser(createFilterConfiguration(configuracion));
		
		if (cfg == null) {
			return configurationRepository.insert(configuracion);
		} else {
			return cfg;
		}
	}
	
	@RequestMapping("/deleteAll")
	public void deleteAll()
	{
		configurationRepository.deleteAll();
	}
	
	@RequestMapping("/deleteById")
	public void deleteById(@RequestParam(value = "id") String id)
	{
		configurationRepository.delete(id);
	}
	
	@RequestMapping("/getById")
	public Configuracion getById(@RequestParam(value = "id") String id)
	{
		return configurationRepository.findOne(id);
	}


	@RequestMapping("/findAll")
	public List<Configuracion> getAllNotifications()
	{
		return configurationRepository.findAll();
	}


	@RequestMapping("/update")
	public Configuracion save(@RequestBody Configuracion configuracion)
	{
		Configuracion cfg = this.findByReferenceUser(createFilterConfiguration(configuracion));
		
		if (cfg != null) {
			cfg.setActiva(configuracion.getActiva());
			return configurationRepository.save(cfg);
		} else {
			return configurationRepository.save(configuracion);
		}
	}

	@RequestMapping("/findByReferenceUser")
	public Configuracion findByReferenceUser(@RequestBody FilterConfiguration filtro) {
		try {
			return configurationRepository.findByReferenceUser(filtro.getTipoAlerta(), 
					filtro.getReferencia(), filtro.getUsuario());
		} catch (Exception e) {
			return new Configuracion();
		}
	}
	
	private FilterConfiguration createFilterConfiguration( Configuracion configuracion) {
		FilterConfiguration filter = new FilterConfiguration();
		filter.setReferencia(configuracion.getReferencia());
		filter.setTipoAlerta(configuracion.getTipoAlerta());
		filter.setUsuario(configuracion.getUsuario());
		return filter;
	}
	
}

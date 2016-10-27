package com.ribbon;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kata16.microservice.pojo.Configuracion;
import com.kata16.microservice.pojo.FilterConfiguration;

@FeignClient("configuracionusuarios")
public interface IConfiguracionUsuarios {

	@RequestMapping(value = "/configuration/create", method = RequestMethod.POST)
	public Configuracion insert(@RequestBody Configuracion configuracion);
	
	@RequestMapping(value = "/configuration/deleteAll", method = RequestMethod.POST)
	public void deleteAll();
	
	@RequestMapping(value = "/configuration/deleteById", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id") String id);
	
	@RequestMapping(value = "/configuration/getById", method = RequestMethod.GET)
	public Configuracion findOne(@RequestParam(value = "id") String id);
	
	@RequestMapping(value = "/configuration/findAll", method = RequestMethod.GET)
	public List<Configuracion> getAllNotifications();
	
	@RequestMapping(value = "/configuration/update", method = RequestMethod.POST)
	public Configuracion save(@RequestBody Configuracion configuracion);

	@RequestMapping(value = "/configuration/findByReferenceUser", method = RequestMethod.GET)
	public Configuracion findByReferenceUser(@RequestBody FilterConfiguration filtro);
	
}

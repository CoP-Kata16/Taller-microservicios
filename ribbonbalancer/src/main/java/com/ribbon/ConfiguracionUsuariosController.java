package com.ribbon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.createnotification.pojo.Configuracion;

@RestController
@RequestMapping("/ribboncfg")
public class ConfiguracionUsuariosController {

	@Autowired
	private IConfiguracionUsuarios iConfiguracionUsuarios; 
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Configuracion create(@RequestBody Configuracion configuracion)
	{
		return iConfiguracionUsuarios.insert(configuracion);
	}
	
	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	public void deleteAll()
	{
		iConfiguracionUsuarios.deleteAll();
	}
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public void deleteById(@RequestParam(value = "id") String id)
	{
		iConfiguracionUsuarios.delete(id);
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public Configuracion getById(@RequestParam(value = "id") String id)
	{
		return iConfiguracionUsuarios.findOne(id);
	}


	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public List<Configuracion> getAllNotifications()
	{
		return iConfiguracionUsuarios.getAllNotifications();
	}


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Configuracion save(@RequestBody Configuracion configuracion)
	{
		return iConfiguracionUsuarios.save(configuracion);
	}
	
}

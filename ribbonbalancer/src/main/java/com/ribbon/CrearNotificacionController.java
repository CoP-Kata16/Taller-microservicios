package com.ribbon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kata16.microservice.pojo.Configuracion;
import com.kata16.microservice.pojo.FilterConfiguration;
import com.kata16.microservice.pojo.FilterReferenceUser;
import com.kata16.microservice.pojo.Notification;
import com.kata16.microservice.pojo.PojoUtil;


@RestController
@RequestMapping("/ribbonnot")
public class CrearNotificacionController 
{

	@Autowired
	private ICrearNotificacion notificacionController;
	
	@Autowired
	private IConfiguracionUsuarios iConfiguracionUsuarios; 
	
	
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public List<Notification> getAllNotifications()
	{
		return notificacionController.getAllNotifications();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Notification create(@RequestBody Notification notification)
	{
		Notification notificationCreate = null;
		
		FilterConfiguration filtro = PojoUtil.createFilterConfiguration(notification);
		Configuracion configUser = iConfiguracionUsuarios.findByReferenceUser(filtro);
		
		if (configUser == null) {
			
			configUser = iConfiguracionUsuarios.insert(PojoUtil.createDefaultConfiguration(notification));
			notificationCreate = notificacionController.insert(notification);
			
		} else {
			
			if (configUser.getActiva()) {
			
				notificationCreate = notificacionController.insert(notification);
			
			} else {
				notificationCreate = PojoUtil.notificationNotCreated(notification);
				System.out.println("Ribbon: no se crea notificacion pq no esta activa: " + configUser.toString());
			}
		}
		return notificationCreate;
	}
	
	@RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
	public void deleteAll()
	{
		notificacionController.deleteAll();
	}

	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public void deleteById(@RequestParam(value = "id") String id)
	{
		notificacionController.delete(id);
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	public Notification getById(@RequestParam(value = "id") String id)
	{
		return notificacionController.findOne(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Notification save(@RequestBody Notification notification)
	{
		return notificacionController.save(notification);
	}
	
	@RequestMapping(value = "/findByReferenceUser", method = RequestMethod.POST)
	public List<Notification> findByReferenceUser(@RequestBody FilterReferenceUser filterReferenceUser)
	{
		return notificacionController.findByReferenceUser(filterReferenceUser);
	}	
	
	
}

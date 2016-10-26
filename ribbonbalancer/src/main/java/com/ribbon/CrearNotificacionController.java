package com.ribbon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.createnotification.pojo.Notification;


@RestController
@RequestMapping("/ribbonnot")
public class CrearNotificacionController 
{

	@Autowired
	private ICrearNotificacion notificacionController;
	
	
	
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public List<Notification> getAllNotifications()
	{
		return notificacionController.getAllNotifications();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Notification create(@RequestBody Notification notification)
	{
		return notificacionController.insert(notification);
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
	
	@RequestMapping("/findByReferenceUser")
	public List<Notification> findByReferenceUser(@RequestParam(value = "reference") String reference, @RequestParam(value = "user") String user)
	{
		return notificacionController.findByReferenceUser(reference, user);
	}	
	
}

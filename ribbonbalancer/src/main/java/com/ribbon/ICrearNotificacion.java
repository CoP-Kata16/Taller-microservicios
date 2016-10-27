package com.ribbon;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kata16.microservice.pojo.FilterReferenceUser;
import com.kata16.microservice.pojo.Notification;

@FeignClient("crearnotificacion")
public interface ICrearNotificacion 
{
	
	@RequestMapping(value = "/notification/findAll", method = RequestMethod.GET)
	public List<Notification> getAllNotifications();
	
	@RequestMapping(value = "/notification/create", method = RequestMethod.POST)
	public Notification insert(@RequestBody Notification notification);
	
	@RequestMapping(value = "/notification/deleteAll", method = RequestMethod.POST)
	public void deleteAll();
	
	@RequestMapping(value = "/notification/deleteById", method = RequestMethod.POST)
	public void delete(@RequestParam(value = "id") String id);
	
	@RequestMapping(value = "/notification/getById", method = RequestMethod.GET)
	public Notification findOne(@RequestParam(value = "id") String id);
	
	@RequestMapping(value = "/notification/update", method = RequestMethod.POST)
	public Notification save(@RequestBody Notification notification);

	@RequestMapping(value = "/notification/findByReferenceUser", method = RequestMethod.GET)
	public List<Notification> findByReferenceUser(@RequestBody FilterReferenceUser filterReferenceUser);
	
	 
	
}

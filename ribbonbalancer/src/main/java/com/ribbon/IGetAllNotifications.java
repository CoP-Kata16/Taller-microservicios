package com.ribbon;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.microservice.createnotification.pojo.Notification;

@FeignClient("crearnotificacion")
public interface IGetAllNotifications {
	
	@RequestMapping(value = "/notification/findAll")
	public List<Notification> getAllNotifications();
	
}

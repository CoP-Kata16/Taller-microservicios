package com.microservice.createnotification;


import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kata16.microservice.pojo.Notification;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CrearNotificacionApplicationTests
{
	@Autowired
	NotificacionController notificacionController;


	@Test
	public void addNotification()
	{
		final String idType = "90";
		final String title = "Cargo superior tarjeta";
		final String descripcion = "Cargo superior en tarjeta con importe de 1.000€ superior al que tiene configurado 900€.";
		Notification notification = createNewNotification(idType, title, descripcion);
		Notification notificationInerted = notificacionController.create(notification);
		System.out.println("Notificaion insertada: " + notificationInerted.toString());
		assertNotNull(notificationInerted);

	}


	private Notification createNewNotification(String idType, String title, String description)
	{
		Notification notification = new Notification();

		notification.setIdType(idType);
		notification.setTitle(title);
		notification.setDescription(description);

		return notification;
	}



}

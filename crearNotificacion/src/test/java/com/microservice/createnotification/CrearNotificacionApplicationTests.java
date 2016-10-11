package com.microservice.createnotification;


import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microservice.createnotification.pojo.Notification;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


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


	@Test
	public void crearNotificacionSergio()
	{

		String idTipo = "47";
		final String host = "mongodb://w963363D.ad.bbva.com:27017/dbTaller";

		MongoClientURI mongoClientURI = new MongoClientURI(host);

		MongoClient mongoClient = new MongoClient(mongoClientURI);

		MongoDatabase db = mongoClient.getDatabase(mongoClientURI.getDatabase());

		MongoCollection<Document> collection = db.getCollection("notificaciones");


		Document document = new Document("Alerta", new Document("Tipo", idTipo).append("Caracteristicas",
				new Document("Titulo", "Cargo superior tarjeta.").append("Descripcion", "Cargo superior en tarjeta con importe de 1.000€ superior al que tiene configurado 900€.")));

		List<Document> arg0 = new ArrayList<Document>();

		arg0.add(document);

		collection.insertMany(arg0);

		mongoClient.close();
	}

}

package com.microservice.createnotification;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class CrearNotificacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrearNotificacionApplication.class, args);
	}
	
	public void notificar()
	{
			
			final String host = "mongodb://pruebas:pruebas@ds041506.mlab.com:41506/microservicios";

			MongoClientURI mongoClientURI = new MongoClientURI(host);
			
			MongoClient mongoClient = new MongoClient(mongoClientURI);
			
			MongoDatabase db = mongoClient.getDatabase(mongoClientURI.getDatabase());

			MongoCollection<Document> collection = db.getCollection("HolaMundo");
			
			Document document = new Document("Alerta", new Document("Tipo", "47").append("Caracteristicas",
					new Document("Titulo", "Cargo superior tarjeta.").append("Descripcion", "Cargo superior en tarjeta con importe de 1.000€ superior al que tiene configurado 900€.")));
			
			List<Document> arg0 = new ArrayList<Document>();
			
			arg0.add(document);
			
			collection.insertMany(arg0);
			
			mongoClient.close();			

	}
	
}

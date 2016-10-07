package com.microservice.createnotification;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
public class NotificacionController {

	@RequestMapping("create")
	public void create(@RequestParam(value="idTipo", defaultValue="47") String idTipo) {
		
		final String host = "mongodb://pruebas:pruebas@ds041506.mlab.com:41506/microservicios";

		MongoClientURI mongoClientURI = new MongoClientURI(host);
		
		MongoClient mongoClient = new MongoClient(mongoClientURI);
		
		MongoDatabase db = mongoClient.getDatabase(mongoClientURI.getDatabase());

		MongoCollection<Document> collection = db.getCollection("HolaMundo");
		
		Document document = new Document("Alerta", new Document("Tipo", idTipo).append("Caracteristicas",
				new Document("Titulo", "Cargo superior tarjeta.").append("Descripcion", "Cargo superior en tarjeta con importe de 1.000€ superior al que tiene configurado 900€.")));
		
		List<Document> arg0 = new ArrayList<Document>();
		
		arg0.add(document);
		
		collection.insertMany(arg0);
		
		mongoClient.close();	
	}
}

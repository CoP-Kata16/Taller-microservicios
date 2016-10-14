package com.microservice.configurationuser.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.configurationuser.pojo.Configuracion;


public interface ConfigurationRepository extends MongoRepository<Configuracion, String>
{}
	


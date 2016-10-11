package com.microservice.createnotification.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservice.createnotification.pojo.Notification;


public interface NotificationRepository extends MongoRepository<Notification, String>
{}

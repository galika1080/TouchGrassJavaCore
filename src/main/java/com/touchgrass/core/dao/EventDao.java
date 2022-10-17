package com.touchgrass.core.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.touchgrass.core.model.Event;

public class EventDao {
    static AmazonDynamoDB client;
    DynamoDBMapper mapper;

    public EventDao() {
        client = AmazonDynamoDBClientBuilder.standard().build();
        mapper = new DynamoDBMapper(client);
    }

    public Event getEvent(String name, long date) {
        return mapper.load(Event.class, date, name);
    }

    public void putEvent(Event event) throws IllegalArgumentException {
        if (event.getName() == null) {
            throw new IllegalArgumentException("Incomplete event provided");
        }

        mapper.save(event);
    }

    public void deleteEvent(Event event) {
        if (event.getName() == null) {
            throw new IllegalArgumentException("Incomplete event provided");
        }

        mapper.delete(event);
    }
}

package com.touchgrass.core.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.touchgrass.core.model.Profile;

public class ProfileDao {
    static AmazonDynamoDB client;
    DynamoDBMapper mapper;

    public ProfileDao() {
        client = AmazonDynamoDBClientBuilder.standard().build();
        mapper = new DynamoDBMapper(client);
    }

    public Profile getProfile(String email) {
        return mapper.load(Profile.class, email);
    }

    public void putProfile(Profile profile) throws IllegalArgumentException {
        if (profile.getEmail() == null) {
            throw new IllegalArgumentException("Incomplete profile provided");
        }

        mapper.save(profile);
    }

    public void deleteProfile(Profile profile) throws IllegalArgumentException {
        if (profile.getEmail() == null) {
            throw new IllegalArgumentException("Incomplete profile provided");
        }

        mapper.delete(profile);
    }
}

package com.touchgrass.core.model;

import java.util.Date;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Events")
public class Event {
    
    @DynamoDBHashKey(attributeName = "EpochSeconds")
    private long epochSeconds;

    @DynamoDBRangeKey(attributeName = "Name")
    private String name;

    @DynamoDBAttribute(attributeName = "Location")
    private String location;

    @DynamoDBAttribute(attributeName = "Description")
    private String description;

    @DynamoDBAttribute(attributeName = "URL")
    private String url;

    @DynamoDBAttribute(attributeName = "Tags")
    private Set<String> tags;

    public void addTag(String tag) {
        tags.add(tag);
    }

    public boolean removeTag(String tag) {
        return tags.remove(tag);
    }

    public Date getDate() {
        return new Date(epochSeconds * 1000);
    }
}

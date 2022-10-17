package com.touchgrass.core.model;

import java.util.Set;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Profiles")
public class Profile {
    
    @DynamoDBHashKey(attributeName = "Email")
    private String email;

    @DynamoDBAttribute(attributeName = "Tags")
    private Set<String> tags;

    public void addTag(String tag) {
        tags.add(tag);
    }

    public boolean removeTag(String tag) {
        return tags.remove(tag);
    }
}

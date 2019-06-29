package com.smash.ladder.aws.data

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName="Player")
class PlayerRequest {
    String Id
    String name

    @DynamoDBHashKey(attributeName="Id")
    String getId() {
        return Id
    }

    @DynamoDBAttribute(attributeName="name")
    String getName() {
        return name
    }
}

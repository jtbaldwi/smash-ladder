package com.smash.ladder.aws.data

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName="Tournament")
class TournamentRequest {

    String Id
    String name
    String description
    String playerId
    String tournamentPlayerId

    @DynamoDBHashKey(attributeName="Id")
    String getId() {
        return Id
    }

    @DynamoDBAttribute(attributeName="name")
    String getName() {
        return name
    }

    @DynamoDBAttribute(attributeName="description")
    String getDescription() {
        return description
    }

    @DynamoDBAttribute(attributeName="playerId")
    String getPlayerId() {
        return playerId
    }

    @DynamoDBAttribute(attributeName="tournamentPlayerId")
    String getTournamentPlayerId() {
        return tournamentPlayerId
    }
}

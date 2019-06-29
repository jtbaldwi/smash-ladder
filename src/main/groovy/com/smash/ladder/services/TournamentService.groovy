package com.smash.ladder.services

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression
import com.smash.ladder.aws.AWSConfig
import com.smash.ladder.aws.data.PlayerRequest
import com.smash.ladder.aws.data.TournamentRequest
import com.smash.ladder.data.Player
import com.smash.ladder.data.Tournament
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
@CompileStatic
class TournamentService {

    @Autowired AWSConfig awsConfig

    static ResponseEntity createTournament(Tournament tournament) {
        new ResponseEntity(HttpStatus.OK)
    }

    // Retrieves Tournament object based on
    ResponseEntity getTournament(String id) {
        DynamoDBMapper mapper = new DynamoDBMapper(awsConfig.amazonDynamoDB())
        TournamentRequest tournamentRequest = new TournamentRequest(Id: id)

        DynamoDBQueryExpression<TournamentRequest> queryExpression = new DynamoDBQueryExpression<TournamentRequest>()
                .withHashKeyValues(tournamentRequest)

        List<TournamentRequest> itemList = mapper.query(TournamentRequest.class, queryExpression)

        Tournament result = mapToTournament(itemList.get(0))
        result.setOwner(getOwner(itemList.get(0).getPlayerId()))

        new ResponseEntity(result, HttpStatus.OK)
    }

    static ResponseEntity updateTournament(Tournament tournament, String id) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity deleteTournament(String id) {
        new ResponseEntity(HttpStatus.OK)
    }

    private static Tournament mapToTournament(TournamentRequest tournamentRequest) {
       return new Tournament(Id: tournamentRequest.getId(),
                name: tournamentRequest.getName(),
                description: tournamentRequest.getDescription())
    }
    private Player getOwner(String playerID) {
        DynamoDBMapper mapper = new DynamoDBMapper(awsConfig.amazonDynamoDB())
        PlayerRequest playerRequest = new PlayerRequest(Id: playerID)

        DynamoDBQueryExpression<PlayerRequest> queryExpression = new DynamoDBQueryExpression<PlayerRequest>()
                .withHashKeyValues(playerRequest)

        List<PlayerRequest> itemList = mapper.query(PlayerRequest.class, queryExpression)

        return new Player(
                Id:  itemList.get(0).getId(),
                name: itemList.get(0).getName()
        )

    }
}

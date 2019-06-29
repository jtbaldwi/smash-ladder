package com.smash.ladder.services

import com.smash.ladder.data.Match
import com.smash.ladder.data.Player
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@CompileStatic
class PlayerService {

    //Constant to determine how much elo will be distributed for the calculation
    int eloWeight = 30

    @Autowired PlayerService playerService

    /**
     * Caluclate Elos based off of match results and save them to DB
     * @param matchResults the results of the match made
     * @return the
     */
    Match updatePlayerElos(Match matchResults) {
        //Player a probability
        float challengedProb = probability(matchResults.challenger.elo, matchResults.challenge.elo)

        //Player b probability
        float challengerProb = probability(matchResults.challenge.elo, matchResults.challenger.elo)

        //Challenger was not successful
        if(!matchResults.advanced) {
            matchResults.challenger.elo = (float) (matchResults.challenger.elo + eloWeight * (1 - challengerProb))
            matchResults.challenge.elo = (float) (matchResults.challenge.elo + eloWeight * (0 - challengerProb))
        } else {
            matchResults.challenger.elo = (float) (matchResults.challenger.elo + eloWeight * (0 - challengerProb))
            matchResults.challenge.elo = (float) (matchResults.challenge.elo + eloWeight * (1 - challengerProb))
        }

        //Get and save players elo from match results
        Player challenger = playerService.getPlayer(matchResults.challenger.id)
        challenger.setElo(matchResults.challenger.elo)
        playerService.save(challenger)

        Player challengee = playerService.getPlayer(matchResults.challenge.id)
        challengee.setElo(matchResults.challenge.elo)
        playerService.save(challengee)

        matchResults
    }


    /**
     * Calculates the probability of players chance of winning based on current rating
     * @param rating1
     * @param rating2
     * @return float probabibility of the player
     */
    static float probability(float rating1, float rating2) {
        return 1.0f * 1.0f / (1 + 1.0f * (float)(Math.pow(10, 1.0f * (rating1 - rating2) / 400)))
    }

}

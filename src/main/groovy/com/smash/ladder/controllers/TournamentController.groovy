package com.smash.ladder.controllers

import com.smash.ladder.data.Player
import com.smash.ladder.data.Tournament
import com.smash.ladder.services.TournamentService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

// CRUD operations for tournament objects
@RestController
@RequestMapping('/api')
@CompileStatic
class TournamentController {

    @Autowired
    TournamentService tournamentService

    /**
     * Create a new tournament object and store to the database
     * @param tournament
     * @return
     */
    @PostMapping(path = 'tournament')
    @ResponseBody
    ResponseEntity createTournament(@RequestBody Tournament tournament) {
        tournamentService.createTournament(tournament)
    }

    /**
     * Fetch a tournament from the DB by its id
     * @param id
     * @return
     */
    @GetMapping(path = 'tournament/{id}')
    @ResponseBody
    ResponseEntity getTournament(@PathVariable String id) {
        tournamentService.getTournament(id)
    }

    /**
     * Update an existing tournament object
     * @param tournament
     * @return
     */
    @PutMapping(path = 'tournament')
    @ResponseBody
    ResponseEntity updateTournament(@RequestBody Tournament tournament) {
        tournamentService.updateTournament(tournament)
    }

    /**
     * Delete an existing tournament object
     * @param id
     * @return
     */
    @DeleteMapping(path = 'tournament/{id}')
    @ResponseBody
    ResponseEntity deleteTournament(@PathVariable String id) {
        tournamentService.deleteTournament(id)
    }

    /**
     * Add a player to a tournament by creating a new TournamentPlayer object
     * @param player
     * @param id
     * @return
     */
    @PostMapping(path = 'tournament/player/{id}')
    @ResponseBody
    ResponseEntity createPlayerInTournament(@RequestBody Player player, @PathVariable String id) {
        tournamentService.createPlayerInTournament(player, id)
    }

    /**
     * Update a player in a tournament by updating a TournamentPlayer object
     * @param id
     * @return
     */
    @PutMapping(path = 'tournament/player/{id}')
    @ResponseBody
    ResponseEntity updatePlayerInTournament(@PathVariable String id) {
        tournamentService.updatePlayerInTournament(id)
    }
}

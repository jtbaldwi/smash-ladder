package com.smash.ladder.controllers

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

    @PostMapping(path = 'tournament')
    @ResponseBody
    ResponseEntity createTournament(@RequestBody Tournament tournament) {
        tournamentService.createTournament(tournament)
    }

    @GetMapping(path = 'tournament/{id}')
    @ResponseBody
    ResponseEntity getTournament(@PathVariable String id) {
        tournamentService.getTournament(id)
    }

    @PutMapping(path = 'tournament/{id}')
    @ResponseBody
    ResponseEntity updateTournament(@RequestBody Tournament tournament, @PathVariable String id) {
        tournamentService.updateTournament(tournament, id)
    }

    @DeleteMapping(path = 'tournament/{id}')
    @ResponseBody
    ResponseEntity deleteTournament(@PathVariable String id) {
        tournamentService.deleteTournament(id)
    }
}

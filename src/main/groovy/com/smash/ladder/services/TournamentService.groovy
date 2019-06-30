package com.smash.ladder.services

import com.smash.ladder.data.Tournament
import groovy.transform.CompileStatic
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
@CompileStatic
class TournamentService {

    static ResponseEntity createTournament(Tournament tournament) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity getTournament(String id) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity updateTournament(Tournament tournament) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity deleteTournament(String id) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity updatePlayerInTournament(String id) {
        new ResponseEntity(HttpStatus.OK)
    }
}

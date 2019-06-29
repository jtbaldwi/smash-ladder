package com.smash.ladder.services

import com.smash.ladder.data.Player
import groovy.transform.CompileStatic
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
@CompileStatic
class PlayerService {

    static ResponseEntity createPlayer(Player player) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity getPlayer(String id) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity updatePlayer(Player player) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity deletePlayer(String id) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity updatePlayerWinLoss(String id) {
        new ResponseEntity(HttpStatus.OK)
    }

    static ResponseEntity updatePlayerElo(String id) {
        new ResponseEntity(HttpStatus.OK)
    }
}

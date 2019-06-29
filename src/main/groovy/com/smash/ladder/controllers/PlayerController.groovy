package com.smash.ladder.controllers

import com.smash.ladder.data.Match
import com.smash.ladder.data.Player
import com.smash.ladder.services.PlayerService
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

@RestController
@RequestMapping('/api')
class PlayerController {

    @Autowired
    PlayerService playerService

    @PostMapping(path = 'player')
    @ResponseBody
    ResponseEntity createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player)
    }

    @GetMapping(path = 'player/{id}')
    @ResponseBody
    ResponseEntity getPlayer(@PathVariable String id) {
        playerService.getPlayer(id)
    }

    @PutMapping(path = 'player')
    @ResponseBody
    ResponseEntity updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player)
    }

    @DeleteMapping(path = 'player/{id}')
    @ResponseBody
    ResponseEntity deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id)
    }

    @PutMapping(path = 'player/{id}/score')
    @ResponseBody
    ResponseEntity updatePlayerWinLoss(@PathVariable String id) {
        playerService.updatePlayerWinLoss(id)
    }

    @PutMapping(path = 'player/elo')
    @ResponseBody
    ResponseEntity updatePlayerElos(@RequestBody Match match) {
        Match matchResults = playerService.updatePlayerElos(match)
        ResponseEntity.ok(matchResults)
    }
}

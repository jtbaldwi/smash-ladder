package com.smash.ladder.controllers

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

    /**
     * Create a new player object
     * @param player
     * @return
     */
    @PostMapping(path = 'player')
    @ResponseBody
    ResponseEntity createPlayer(@RequestBody Player player) {
        playerService.createPlayer(player)
    }

    /**
     * Get a player object by its id
     * @param id
     * @return
     */
    @GetMapping(path = 'player/{id}')
    @ResponseBody
    ResponseEntity getPlayer(@PathVariable String id) {
        playerService.getPlayer(id)
    }

    /**
     * Update an existing player object
     * @param player
     * @return
     */
    @PutMapping(path = 'player')
    @ResponseBody
    ResponseEntity updatePlayer(@RequestBody Player player) {
        playerService.updatePlayer(player)
    }

    /**
     * Delete an existing player object
     * @param id
     * @return
     */
    @DeleteMapping(path = 'player/{id}')
    @ResponseBody
    ResponseEntity deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id)
    }

    /**
     * Update an existing player objects score (consistent across ALL tournaments)
     * @param id
     * @return
     */
    @PutMapping(path = 'player/{id}/score')
    @ResponseBody
    ResponseEntity updatePlayerWinLoss(@PathVariable String id) {
        playerService.updatePlayerWinLoss(id)
    }

    /**
     * Update an existing player objects elo (consistent across ALL tournaments)
     * @param id
     * @return
     */
    @PutMapping(path = 'player/{id}/elo')
    @ResponseBody
    ResponseEntity updatePlayerElo(@PathVariable String id) {
        playerService.updatePlayerElo(id)
    }
}

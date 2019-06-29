package com.smash.ladder.controllers

import com.smash.ladder.services.LadderService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/ladder')
@CompileStatic
class LadderController {

    @Autowired LadderService ladderService

    @PostMapping( path = 'new')
    @ResponseBody ResponseEntity createLadder() {
        ladderService.createLadder()
    }
}

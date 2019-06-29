package com.smash.ladder.services

import groovy.transform.CompileStatic
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
@CompileStatic
class LadderService {

    static ResponseEntity createLadder() {
        new ResponseEntity(HttpStatus.OK)
    }
}

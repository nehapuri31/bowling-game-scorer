package com.bowling.app.bowlinggamescorer.controller;

import com.bowling.app.bowlinggamescorer.entity.GameResponse;
import com.bowling.app.bowlinggamescorer.exception.ErrorResponse;
import com.bowling.app.bowlinggamescorer.service.BowlingGameService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.Array;

/**
 * Controller Endpoint for Bowling Game Score calculation.
 * Created by nehapuri on 11/10/18.
 *
 * @version 1.0
 */

@RestController
@RequestMapping("/v1/score-calculation")
@Slf4j
@AllArgsConstructor
public class BowlingGameScoreController {

    private BowlingGameService service;

    @ApiOperation(value = "Calculate the score for individual frame of Bowling Game")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "return a list of scores for each frame", response = Array.class),
            @ApiResponse(code = 404, message = "Invalid Input", response = ErrorResponse.class)
    })
    @PostMapping(value = "/by-game", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.ALL_VALUE)
    public GameResponse getScoreForGame(@RequestBody @Valid int[] pinsCount) {
        return service.process(pinsCount);
    }
}

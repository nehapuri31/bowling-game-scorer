package com.bowling.app.bowlinggamescorer.service;

import com.bowling.app.bowlinggamescorer.entity.GameResponse;
import com.bowling.app.bowlinggamescorer.exception.InvalidInputException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service to calculate the fetch the score of bowling game as per the input pins
 * and return the Object of score and sum
 * Created by nehapuri on 11/10/18.
 */
@Service
@AllArgsConstructor
public class BowlingGameService {
    private final ScoreCalculator scoreCalculator;

    public GameResponse process(int[] knockedPinsCount) {
        ArrayList<Integer> scores = scoreCalculator.getScore(knockedPinsCount);
        return toFrameOutput(scores);
    }

    private GameResponse toFrameOutput(ArrayList<Integer> scores) {
        return GameResponse.builder()
                .scores(scores)
                .sum(scores.stream().mapToInt(Integer::intValue).sum())
                .build();
    }
}

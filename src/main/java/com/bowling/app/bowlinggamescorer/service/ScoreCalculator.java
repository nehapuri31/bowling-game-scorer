package com.bowling.app.bowlinggamescorer.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service to calculate the score of bowling game as per the input pins
 * Created by nehapuri on 11/10/18.
 */
@Service
class ScoreCalculator {

    /**
     * Takes the array of knocked down pins in each roll and gives the score for each frame
     *
     * @param knockedPinsCount number of pins knocked down
     * @return array of score for each frame
     */
    ArrayList<Integer> getScore(int[] knockedPinsCount) {
        ArrayList<Integer> score = new ArrayList<>(10);
        int pinsIndex = 0;
        for (int frame = 0; frame < 10 && pinsIndex < knockedPinsCount.length; frame++) {
            int rollOne = knockedPinsCount[pinsIndex];
            if (indexInBound(knockedPinsCount, pinsIndex + 1)) {
                int rollTwo = isEqualToTen(rollOne) ? 0 : knockedPinsCount[pinsIndex + 1];
                if (isEqualToTen(rollOne)) {
                    if (indexInBound(knockedPinsCount, pinsIndex + 2)) {
                        score.add(rollOne + knockedPinsCount[pinsIndex + 1] + +knockedPinsCount[pinsIndex + 2]);
                    }
                } else if (isEqualToTen(rollOne + rollTwo)) {
                    if (indexInBound(knockedPinsCount, pinsIndex + 2)) {
                        score.add(rollOne + rollTwo + knockedPinsCount[pinsIndex + 2]);
                    }
                } else
                    score.add(rollOne + rollTwo);
                pinsIndex += isEqualToTen(rollOne) ? 1 : 2;
            }
        }
        return score;
    }

    private boolean isEqualToTen(int rollOne) {
        return rollOne == 10;
    }

    private static boolean indexInBound(int[] data, int index) {
        return data != null && index >= 0 && index < data.length;
    }

}

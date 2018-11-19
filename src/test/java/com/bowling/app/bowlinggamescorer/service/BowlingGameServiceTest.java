package com.bowling.app.bowlinggamescorer.service;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Performs the test on Bowling Game Score calculator
 * Created by nehapuri on 11/10/18.
 */
public class BowlingGameServiceTest {

    private final ScoreCalculator scoreCalculator = new ScoreCalculator();
    private final int[] pins = new int[21];

    @Test
    public void no_knocked_pins_game() throws Exception {
        givenKnockedPins(20, 0, 0);
        ArrayList<Integer> score = whenScoreIsCalculated();
        thenScoreIs(score, 0);
    }

    @Test
    public void all_knocked_pins_game() throws Exception {
        givenKnockedPins(12, 10, 0);
        ArrayList<Integer> score = whenScoreIsCalculated();
        thenScoreIs(score, 300);
    }

    @Test
    public void spare_before_rolls() throws Exception {
        giveASpare(0);
        givenKnockedPins(2, 2, 2);
        givenKnockedPins(16, 0, 4);
        ArrayList<Integer> score = whenScoreIsCalculated();
        thenScoreIs(score, 16);
    }

    @Test
    public void strike_before_rolls() throws Exception {
        givenAStrike(0);
        givenKnockedPins(2, 2, 1);
        givenKnockedPins(16, 0, 3);
        ArrayList<Integer> score = whenScoreIsCalculated();
        thenScoreIs(score, 18);
    }

    @Test
    public void strike_last_frame() throws Exception {
        givenKnockedPins(18, 0, 0);
        givenAStrike(18);
        givenKnockedPins(2, 2, 19);
        ArrayList<Integer> score = whenScoreIsCalculated();
        thenScoreIs(score, 14);
    }

    private void thenScoreIs(ArrayList<Integer> score, int expectedScore) {
        assertThat(score.stream().mapToInt(Integer::intValue).sum(), is(expectedScore));

    }

    private ArrayList<Integer> whenScoreIsCalculated() {
        return scoreCalculator.getScore(pins);
    }

    private void givenAStrike(int index) {
        pins[index] = 10;
    }

    private void giveASpare(int index) {
        pins[index] = 5;
        pins[index + 1] = 5;
    }

    private void givenKnockedPins(int count, int pinsScored, int index) {
        for (int i = index; i < count + index; i++)
            pins[i] = pinsScored;
    }
}
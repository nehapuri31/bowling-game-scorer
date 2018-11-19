package com.bowling.app.bowlinggamescorer.entity;


import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

/**
 * Created by nehapuri on 11/19/18.
 */
@Data
@Builder
public class GameResponse {
    ArrayList<Integer> scores;
    int sum;
}

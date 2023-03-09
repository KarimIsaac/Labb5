package edu.lernia.labb5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {

    @Test
void isYatziWhenAllDiceMatches() {
    Die[] dice = new Die[5];
    for (int i = 0; i < dice.length; i++) {
        dice[i] = new Die(6);
    }
    assertTrue(YatziMain.isYatzi(dice));
}

@Test
void isNotYatziWhenOneDieIsNotMatchingTheOther() {
    Die[] dice = new Die[5];
    for (int i = 0; i < dice.length - 1; i++) {
        dice[i] = new Die(6);
    }
    dice[4] = new Die(1);
    assertTrue(YatziMain.isYatzi(dice));
}

}

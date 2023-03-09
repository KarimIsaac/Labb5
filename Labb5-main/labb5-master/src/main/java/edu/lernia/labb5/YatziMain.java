package edu.lernia.labb5;

import java.util.Scanner;

public class YatziMain {

    private static final int NUM_DICE = 5;
    private static final int MAX_TURNS = 3;
    private static Die[] dice;
    private static boolean gameIsOn = true;

    public static void main(String[] args) {
        initDice();
        playGame();
    }

    private static void initDice() {
        dice = new Die[NUM_DICE];
        for (int i = 0; i < NUM_DICE; i++) {
            dice[i] = new Die();
        }
    }

    private static void playGame() {
        while (gameIsOn) {
            int currentTurn = 0;
            System.out.println("Welcome to Yatzi!");

            while (currentTurn < MAX_TURNS) {
                System.out.println("Starting turn " + (currentTurn + 1) + " of " + MAX_TURNS + ", rolling dice.");
                rollDice();
                if (isYatzi()) {
                    System.out.println("You got YATZI! in " + dice[0].value + "'s");
                    return;
                } else if (currentTurn == MAX_TURNS - 1) {
                    System.out.println("Game over! Want to play again?");
                    if (!askToPlayAgain()) {
                        gameIsOn = false;
                        break;
                    }
                } else {
                    if (!askToThrowAgain()) {
                        gameIsOn = false;
                        break;
                    }
                    currentTurn++;
                }
            }
        }
    }

    private static void rollDice() {
        for (int i = 0; i < NUM_DICE; i++) {
            dice[i].DieRoll();
            System.out.println(i + ": " + dice[i].getString());
        }
    }

    private static boolean isYatzi() {
        for (int i = 1; i < NUM_DICE; i++) {
            if (dice[i].value != dice[i - 1].value) {
                return false;
            }
        }
        return true;
    }

    private static boolean askToThrowAgain() {
        System.out.println("Want to throw again? (y for yes, anything else for no)");
        Scanner sc = new Scanner(System.in);
        return sc.next().equals("y");
    }

    private static boolean askToPlayAgain() {
        Scanner sc = new Scanner(System.in);
        return sc.next().equals("y");
    }

    static boolean isYatzi(Die[] dice) {
        for (int i = 1; i < NUM_DICE; i++) {
            if (dice[i].value != dice[i - 1].value) {
                return false;
            }
        }
        return true;
    }
}

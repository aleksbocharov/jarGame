package com.teamtreehouse;

import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);
    private Jar mJar;
    private int mAttempts;
    private String mPlayerName;

    public Game(Jar jar) {
        mJar = jar;
        mAttempts = 1;
    }

    public int getAttempts() {
        return mAttempts;
    }

    public String getPlayerName() {
        return mPlayerName;
    }

    public void playGame(){

        promptPlayer();
        while (!makeGuess()) {
            mAttempts++;
        }
        System.out.printf("Congrats you won! It took you %d mAttempts.%n", mAttempts);
    }

    private void promptPlayer(){
        System.out.printf("%nPlayer%n---------%n");
        System.out.print("Please, enter your name: ");
        mPlayerName = scan.next();
        System.out.printf("%s, please guess how many %s in the jar. " +
                        "Your guess should be between %d and %d.%n",
                mPlayerName, mJar.getItemName(), 1, mJar.getMaxQuantity());
    }

    private boolean makeGuess(){
        boolean won;

        System.out.print("Enter your guess: ");
        int guess = scan.nextInt();
        while (guess> mJar.getMaxQuantity()){
            System.out.printf("Guess is above limit. Should be below %d.%n", mJar.getMaxQuantity());
            System.out.print("Try again. Enter your guess: ");
            guess = scan.nextInt();
        }
        int diff = checkGuess(guess);
        if (diff==0){
            System.out.printf("%d is a correct guess.%n", guess);
            won = true;
        }
        else {
            System.out.printf("%d is a wrong guess. ", guess);
            System.out.println(diff>0?"It's too high":"It's too low");
            won = false;
        }

        return won;
    }

    private int checkGuess(int guess){
        return guess - mJar.getItemsQuantity();
    }
}

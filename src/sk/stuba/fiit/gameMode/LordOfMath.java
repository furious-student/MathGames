package sk.stuba.fiit.gameMode;

import sk.stuba.fiit.gameMode.GameMode;

import java.util.ArrayList;

public class LordOfMath extends GameMode {
    public LordOfMath() {
        super("LordOfMath");
    }


    @Override
    public void printGameModeMenu() {
        // LordOfMath game menu
        System.out.println(
                """
                        Welcome in the LordOfMathMode mode!
                        Choose topics to include in the game (enter numbers of topics you want to include separated by space):
                        \t0 -> Go Back
                        \t------------------
                        \t1 -> Arithmetics
                        \t2 -> Algebra
                        \t3 -> Linear Equations"""
        ); // Eclipse?
    }

    @Override
    public void play(ArrayList<Integer> typeOfExercises) {

    }

    public void addPoints() {
        super.addPoints(1);
    }
}

package sk.stuba.fiit.gameMode;

import sk.stuba.fiit.gameMode.GameMode;

import java.util.ArrayList;

public class TheTrueSolver extends GameMode {

    public TheTrueSolver() {
        super("TheTrueSolver");
    }

    @Override
    public void printGameModeMenu() {
        // TheTrueSolver game menu
        System.out.println(
                """
                        Welcome in the TheTrueSolver mode!
                        Choose topics to include in the game (enter numbers of topics you want to include separated by space):
                        \t0 -> Go Back
                        \t------------------
                        \t1 -> Arithmetics 
                        \t2 -> Algebra
                        \t3 -> Linear Equations
                        \t4 -> Quadratic Equations
                        \t5 -> Geometry
                        \t7 -> Matrices"""
        ); // Eclipse?
    }

    @Override
    public void play(ArrayList<Integer> typeOfExercises) {

    }

    public void addPoints() {
        super.addPoints(2);
    }

    public void removePoints() {
        super.removePoints(0.5);
    }
}

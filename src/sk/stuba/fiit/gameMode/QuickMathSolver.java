package sk.stuba.fiit.gameMode;

import java.util.ArrayList;

public class QuickMathSolver extends GameMode {

    public QuickMathSolver() {
        super("QuickMathSolver");
    }



    public void addPoints() {
        super.addPoints(1);
    }

    public void removePoints() {
        super.removePoints(0.2);
    }

    @Override
    public void printGameModeMenu() {
        // QuickMathSolver menu
        System.out.println(
                """
                        Welcome in the QuickMathSolver mode!
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
}

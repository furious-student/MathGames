package sk.stuba.fiit.math.exercises;

import sk.stuba.fiit.math.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Exercise {


    // ============================= UTILITY PRINT FUNCTIONS =============================
    public final void printKudos() {
        System.out.println("Kudos! Your solution is correct.");
    }

    public final void printError() {
        System.out.println("Better luck next time! your solution was incorrect.");
    }

    public abstract void generateExercise();
    public abstract boolean isSolutionCorrect();
    public abstract void getUserSolution();
}

package sk.stuba.fiit.math.exercises;

import sk.stuba.fiit.math.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Exercise {


    // ============================= UTILITY PRINT FUNCTIONS =============================
    public void printKudos() {
        System.out.println("Kudos! Your solution is correct.");
    }

    public void printError() {
        System.out.println("Better luck next time! your solution was incorrect.");
    }

    public abstract void generateExercise();
}

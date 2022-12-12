package sk.stuba.fiit.gameMode;

import sk.stuba.fiit.math.RandomNumber;
import sk.stuba.fiit.math.exercises.algebraAndArithmetics.AlgebraicExercise;
import sk.stuba.fiit.math.exercises.algebraAndArithmetics.ArithmeticExercise;
import sk.stuba.fiit.math.exercises.equation.EquationExercise;

import java.util.ArrayList;
import java.util.Scanner;

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
                        \t1 -> Arithmetics 
                        \t2 -> Algebra
                        \t3 -> Linear Equations"""
        ); // Eclipse?
    }

    @Override
    public void play(ArrayList<Integer> typeOfExercises) {
        for (int i = 0; i < typeOfExercises.size(); i++) {
            if (typeOfExercises.get(i) < 1 || typeOfExercises.get(i) > 3 || typeOfExercises.size() > 3) {
                System.out.println("Invalid selection");
                return;
            }

            switch (typeOfExercises.get(i)) {
                case 1 -> {
                    addExercise(new ArithmeticExercise());
                }
                case 2 -> {
                    addExercise(new AlgebraicExercise());
                }
                case 3 -> {
                    addExercise(new EquationExercise());
                }
            }
        }
        int numberOfQuestions = 0;
        System.out.println("How many exercises do you want? Enter positive integer from interval <5,20>: ");
        Scanner scanner = new Scanner(System.in);
        try {
            numberOfQuestions = Integer.parseInt(scanner.nextLine());
            if (numberOfQuestions < 5 || numberOfQuestions > 20) {
                numberOfQuestions = 10;
            }
        } catch (Exception e) {
            numberOfQuestions = 10;
        }

        int randomExercisePick;
        for (int i = 0; i < numberOfQuestions; i++) {
            randomExercisePick = RandomNumber.generate(0, typeOfExercises.size());
            if (getExercises().get(randomExercisePick).generateExercise(true)) {
                addPoints();
            } else {
                removePoints();
            }
        }
    }
}

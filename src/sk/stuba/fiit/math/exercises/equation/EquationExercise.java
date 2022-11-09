package sk.stuba.fiit.math.exercises.equation;

import sk.stuba.fiit.math.exercises.Exercise;

import java.util.Scanner;

public class EquationExercise extends Exercise {

    private int userSolution;

    private LinearEquation linearEquation;

    @Override
    public void generateExercise() {
        this.linearEquation = new LinearEquation();

        generateLinearEquationExercise();
    }

    private void generateLinearEquationExercise() {
        System.out.println("Given the equation:");
        linearEquation.generate();
        linearEquation.print();
        System.out.println("find the solution for x in whole numbers (input one whole number):");
        getUserSolution();

        if (isSolutionCorrect()) {
            super.printKudos();
        } else {
            super.printError();
            System.out.print("Your solution: ");
            System.out.println(this.userSolution);
            System.out.print("Correct solution: ");
            System.out.println(this.linearEquation.getLinearSolution());
        }
    }

    private boolean isSolutionCorrect() {
        return this.linearEquation.equals(this.userSolution);
    }

    private void getUserSolution() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            this.userSolution = scanner.nextInt();
        } else {
            this.userSolution = this.linearEquation.getLinearSolution() + 1;
        }
        scanner.nextLine();
    }
}

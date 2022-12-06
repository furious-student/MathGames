package sk.stuba.fiit.math.exercises.algebraAndArithmetics;

import sk.stuba.fiit.math.exercises.Exercise;

import java.util.Scanner;

public class ArithmeticExercise extends Exercise {
    private Arithmetics arithmetics;
    private double userSolution;

    @Override
    public void generateExercise() {
        this.arithmetics = new Arithmetics();
        this.arithmetics.generate();
        System.out.println("Find the solution of given expression: ");
        this.arithmetics.print();
        System.out.println("Input your solution: ");
        getUserSolution();

        if (isSolutionCorrect()) {
            printKudos();
        } else {
            printError();
            System.out.println("Your solution: " + this.userSolution);
            System.out.println("Correct solution: " + this.arithmetics.getSolution());
        }
    }

    @Override
    public boolean isSolutionCorrect() {
        return this.arithmetics.equals(this.userSolution);
    }

    @Override
    public void getUserSolution() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            this.userSolution = scanner.nextDouble();
        }
        scanner.nextLine();
    }
}

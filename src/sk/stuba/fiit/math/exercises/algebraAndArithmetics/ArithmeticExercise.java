package sk.stuba.fiit.math.exercises.algebraAndArithmetics;

import sk.stuba.fiit.math.RandomNumber;
import sk.stuba.fiit.math.exercises.Exercise;

import java.util.Scanner;

public class ArithmeticExercise extends Exercise {
    private Arithmetics arithmetics;
    private double userSolution;

    @Override
    public boolean generateExercise(boolean printOptions) {
        this.arithmetics = new Arithmetics();
        this.arithmetics.generate();
        System.out.println("Find the solution of given expression: ");
        this.arithmetics.print();
        if (printOptions) {
            printOptions();
        }
        System.out.println("Input your solution: ");
        getUserSolution();

        if (isSolutionCorrect()) {
            printKudos();
        } else {
            printError();
            System.out.println("Your solution: " + this.userSolution);
            System.out.println("Correct solution: " + this.arithmetics.getSolution());
        }

        return super.isCorrect();
    }

    @Override
    public void printOptions() {
        int correct = RandomNumber.generate(1, 6);
        for (int i = 65; i < 70; i++) {
            if (i - 64 == correct) {
                System.out.println("\t" + ((char) i) + ") " + ((int) this.arithmetics.getSolution()));
            } else {
                System.out.println("\t" + ((char) i) + ") " + RandomNumber.generate(-200, 210));
            }
        }
    }

    @Override
    public boolean isSolutionCorrect() {
        super.setCorrect(this.arithmetics.equals(this.userSolution));
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

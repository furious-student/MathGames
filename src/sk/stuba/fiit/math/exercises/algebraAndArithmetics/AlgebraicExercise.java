package sk.stuba.fiit.math.exercises.algebraAndArithmetics;

import sk.stuba.fiit.math.exercises.Exercise;

import java.util.Scanner;

public class AlgebraicExercise extends Exercise {
    private Algebra algebra;
    private double userSolution;

    @Override
    public void generateExercise() {
        this.algebra = new Algebra();
        this.algebra.generate();
        System.out.println("Find the solution of given expression: ");
        this.algebra.print();
        System.out.println("Input your solution: ");
        getUserSolution();

        if (isSolutionCorrect()) {
            printKudos();
        } else {
            printError();
            System.out.println("Your solution: " + this.userSolution);
            System.out.println("Correct solution: " + this.algebra.getSolution());
        }
    }

    @Override
    public boolean isSolutionCorrect() {
        return this.algebra.equals(this.userSolution);
    }

    @Override
    public void getUserSolution() {
        Scanner scanner = new Scanner(System.in);
        String solution = scanner.nextLine();
        try {
            this.userSolution = Double.parseDouble(solution);
        } catch (Exception e) {
            e.printStackTrace();
            this.userSolution = this.algebra.getSolution()-1;
        }
    }
}

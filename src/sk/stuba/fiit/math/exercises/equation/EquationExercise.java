package sk.stuba.fiit.math.exercises.equation;

import sk.stuba.fiit.math.RandomNumber;
import sk.stuba.fiit.math.exercises.Exercise;

import java.util.Scanner;

public class EquationExercise extends Exercise {

    private double[] userSolutions;
    private LinearEquation linearEquation = null;
    private QuadraticEquation quadraticEquation = null;

    @Override
    public void generateExercise() {
        int decision = RandomNumber.generate(-1,1);
        if (decision < 0) {
            this.linearEquation = new LinearEquation();
            generateLinearEquationExercise();
        } else {
            this.quadraticEquation = new QuadraticEquation();
            generateQuadraticEquationExercise();
        }
    }

    private void generateLinearEquationExercise() {
        System.out.println("Given the equation:");
        this.linearEquation.generate();
        this.linearEquation.print();
        System.out.println("find the solution for x in whole numbers (input one whole number):");
        getUserSolution();

        if (isSolutionCorrect()) {
            super.printKudos();
        } else {
            super.printError();
            System.out.print("Your solution: ");
            System.out.println(this.userSolutions[0]);
            System.out.print("Correct solution: ");
            System.out.println(this.linearEquation.getLinearSolution());
        }
    }

    private void generateQuadraticEquationExercise() {
        System.out.println("Given the equation:");
        this.quadraticEquation.generate();
        this.quadraticEquation.print();
        System.out.println("find the solution for x in rational numbers (input two rational numbers with 2 decimal digit precision):");
        getUserSolution();

        if (isSolutionCorrect()) {
            super.printKudos();
        } else {
            super.printError();
            System.out.print("Your solution: ");
            System.out.println("x1 = " + this.userSolutions[0] + ", x2 = " + this.userSolutions[1]);
            System.out.print("Correct solution: ");
            System.out.println("x1 = " + this.quadraticEquation.getLinearSolution() + ", x2 = " + this.quadraticEquation.getSecondSolution());
        }
    }

    @Override
    public boolean isSolutionCorrect() {
        if (this.linearEquation != null) {
            return this.linearEquation.equals(this.userSolutions[0]);
        }

        return this.quadraticEquation.equals(this.userSolutions);
    }

    @Override
    public void getUserSolution() {
        this.userSolutions = new double[2];
        Scanner scanner = new Scanner(System.in);
        String[] solutions = scanner.nextLine().split(" ");

        try {
            for (int i = 0; i<solutions.length; i++){
                this.userSolutions[i] = Double.parseDouble(solutions[i]);
            }
        } catch (Exception e) {
                this.userSolutions = null;
        }
    }
}

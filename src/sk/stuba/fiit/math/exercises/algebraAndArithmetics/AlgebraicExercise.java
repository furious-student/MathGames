package sk.stuba.fiit.math.exercises.algebraAndArithmetics;

import sk.stuba.fiit.math.RandomNumber;
import sk.stuba.fiit.math.exercises.Exercise;

import java.util.Scanner;

public class AlgebraicExercise extends Exercise {
    private Algebra algebra;
    private double userSolution;

    @Override
    public boolean generateExercise(boolean printOptions) {
        this.algebra = new Algebra();
        this.algebra.generate();
        System.out.println("Find the solution of given expression: ");
        this.algebra.print();
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
            System.out.println("Correct solution: " + this.algebra.getSolution());
        }

        return super.isCorrect();
    }

    @Override
    public void printOptions() {
        int correct = RandomNumber.generate(1, 6);
        for (int i = 65; i < 70; i++) {
            if (i - 64 == correct) {
                System.out.println("\t" + ((char) i) + ") " + this.algebra.getSolution());
            } else {
                if (this.algebra.getSign() == '/') {
                    System.out.println("\t" + ((char) i) + ") " + RandomNumber.generate(-200.0, 210.0));
                } else {
                    System.out.println("\t" + ((char) i) + ") " + RandomNumber.generate(-200, 210));
                }
            }
        }
    }

    @Override
    public boolean isSolutionCorrect() {
        super.setCorrect(this.algebra.equals(this.userSolution));
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

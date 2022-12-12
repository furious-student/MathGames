package sk.stuba.fiit.math.exercises.matrix;

import sk.stuba.fiit.math.RandomNumber;
import sk.stuba.fiit.math.exercises.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixExercise extends Exercise {
    private Matrix a;
    private Matrix b;
    private Matrix c;
    private Matrix userMatrix;
    // ============================= MATRICES =============================
    @Override
    public boolean generateExercise(boolean printOptions) {
        int random = RandomNumber.generate(-1, 1);
        if (random < 0) {
            generateMatrixAddition();
        } else {
            generateMatrixMultiplication();
        }

        return super.isCorrect();
    }

    @Override
    public void printOptions() {

    }

    private void generateMatrixAddition() {
        int sizeM = RandomNumber.generate(1, 5);
        int sizeN = RandomNumber.generate(1, 5);
        this.a = new Matrix(sizeM, sizeN);
        this.b = new Matrix(sizeM, sizeN);
        this.a.generate(-50, 50);
        this.b.generate(-50, 50);

        System.out.println("Given Matrix A =");
        this.a.print();
        System.out.println("and matrix B =");
        this.b.print();
        System.out.println("Find the sum of these matrices (enter each row, numbers separated by space): ");
        getUserSolution();

        this.c = this.a.add(this.b);

        if (isSolutionCorrect()) {
            super.printKudos();
        } else {
            super.printError();
            System.out.println("Your solution:");
            this.userMatrix.print();
            System.out.println("Correct solution:");
            this.c.print();
        }
    }

    private void generateMatrixMultiplication() {
        int sizeM = RandomNumber.generate(1, 5);
        int sizeS = RandomNumber.generate(1, 5);
        int sizeN = RandomNumber.generate(1, 5);
        this.a = new Matrix(sizeM, sizeS);
        this.b = new Matrix(sizeS, sizeN);
        this.a.generate(-50, 50);
        this.b.generate(-50, 50);

        System.out.println("Given Matrix A =");
        this.a.print();
        System.out.println("and matrix B =");
        this.b.print();
        System.out.println("Find the product of these matrices (enter each row, numbers separated by space): ");
        getUserSolution();

        this.c = this.a.multiply(this.b);

        if (isSolutionCorrect()) {
            super.printKudos();
        } else {
            super.printError();
            System.out.println("Your solution:");
            this.userMatrix.print();
            System.out.println("Correct solution:");
            this.c.print();
        }
    }

    @Override
    public boolean isSolutionCorrect() {
        setCorrect(this.userMatrix.equals(this.c));
        return this.userMatrix.equals(this.c);
    }

    @Override
    public void getUserSolution() {
        List<List<Integer>> body = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String number;
        String[] row;
        int sizeM = 0;
        int sizeN = 0;

        while((number = scanner.nextLine()).length() >= 1) {
            row = number.split(" ");
            sizeN = row.length;
            body.add(sizeM, new ArrayList<>());
            for (int i = 0; i < row.length; i++) {
                try {
                    body.get(sizeM).add(Integer.parseInt(row[i]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sizeM++;
        }

        this.userMatrix = new Matrix(sizeM, sizeN);
        userMatrix.setBody(body);
    }
}

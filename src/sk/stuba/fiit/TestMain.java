package sk.stuba.fiit;

import sk.stuba.fiit.math.exercises.Exercise;
import sk.stuba.fiit.math.exercises.matrix.MatrixExercise;

public class TestMain {
    public static void main(String[] args) {


        /* Works
        System.out.println("Matrix A:");
        Matrix matrixA = new Matrix(10, 10);
        matrixA.generate(-5, 5);
        matrixA.print();

        System.out.println("\nMatrix B:");
        Matrix matrixB = new Matrix(10, 10);
        matrixB.generate(-5, 5);
        matrixB.print();

        System.out.println("\nMatrix C (A+B):");
        matrixA.add(matrixB).print();

        System.out.println("\nMatrix D (A*B):");
        matrixA.multiply(matrixB).print();

        System.out.println();
        List<List<Integer>> matrixBody = new ArrayList<>();
        List<List<Integer>> matrixBody2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            matrixBody.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                matrixBody.get(i).add((j+i)*2+i);
            }
        }
        for (int i = 0; i < 4; i++) {
            matrixBody2.add(new ArrayList<>());
            for (int j = 0; j < 4; j++) {
                matrixBody2.get(i).add((j+i)*2+i);
            }
        }
        Matrix manualMatrix = new Matrix(5, 4);
        Matrix manualMatrix2 = new Matrix(4, 4);
        manualMatrix.setBody(matrixBody);
        manualMatrix2.setBody(matrixBody2);
        manualMatrix.print();
        System.out.println();
        manualMatrix2.print();
        System.out.println(manualMatrix.equals(manualMatrix2));*/

        //GameMode game = new QuickMathSolver();
        //game.startTime();

/*
        Matrix a = new Matrix(2, 1);
        Matrix b = new Matrix(1, 3);
        a.generate();
        b.generate();
        a.print();
        System.out.println();
        b.print();
        System.out.println();
        a.multiply(b).print();
        */


        Exercise exercise = new MatrixExercise();
        exercise.generateExercise();

    }

}

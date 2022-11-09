package sk.stuba.fiit.math.exercises.equation;

import sk.stuba.fiit.math.RandomNumber;

public class QuadraticEquation extends LinearEquation {
    private int quadraticSolution;
    private int[] quadraticCoefficients;

    @Override
    public void generate() {
        super.generate();
        do {
            this.quadraticSolution = RandomNumber.generate(-20, 20);
        } while(this.quadraticSolution == 0);
    }
}

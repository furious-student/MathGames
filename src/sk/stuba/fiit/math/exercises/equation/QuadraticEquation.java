package sk.stuba.fiit.math.exercises.equation;

import sk.stuba.fiit.math.RandomNumber;

import java.text.DecimalFormat;
import java.util.Arrays;

public class QuadraticEquation extends LinearEquation {
    private double quadraticSolution;
    private double secondSolution;
    private int[] quadraticCoefficients;

    public double getSecondSolution() {
        return secondSolution;
    }

    private void generateQuadraticCoefficients() {
        for (int i = 0; i < this.quadraticCoefficients.length; i++) {
            do {
                this.quadraticCoefficients[i] = RandomNumber.generate(-getLIMIT_COEFFICIENT_VALUE(), getLIMIT_COEFFICIENT_VALUE());
            } while (this.quadraticCoefficients[i] == 0);
        }
    }

    void findSecondSolution(int rightSide) {
        int a = 0;
        for (int quadraticCoefficient : this.quadraticCoefficients) {
            a += quadraticCoefficient;
        }
        int b = 0;
        for(int linearCoefficient : getLinearCoefficients()) {
            b += linearCoefficient;
        }
        int c = 0;
        for (int constant : getConstants()) {
            c += constant;
        }
        c += rightSide * (-1);

        double discriminant = Math.pow(b, 2) - (4 * a * c);
        double x1 = (-b + Math.sqrt(discriminant)) / (2*a);
        double x2 = (-b - Math.sqrt(discriminant)) / (2*a);

        this.secondSolution = (x1 == this.quadraticSolution) ? x2 : x1;
        DecimalFormat df = new DecimalFormat("#.##");
        this.secondSolution = Double.parseDouble(df.format(this.secondSolution).replace(',', '.'));

    }

    // ============================== OVERRIDDEN METHODS  ======================================
    @Override
    public void generate() {
        super.generate();
        this.quadraticSolution = getLinearSolution();
        this.quadraticCoefficients = new int[RandomNumber.generate(1, getLIMIT_COEFFICIENT_VALUE())];
        generateQuadraticCoefficients();
    }

    @Override
    public void print() {
        if (getLinearCoefficients() == null || getConstants() == null || this.quadraticCoefficients == null) {
            return;
        }
        boolean firstSign = true;
        int numberOfConstants = getConstants().length;
        int numberOfLinearCoefficients = getLinearCoefficients().length;
        int numberOfQuadraticCoefficients = this.quadraticCoefficients.length;
        int rightSide = 0;
        int x;
        char sign = '0';
        while (numberOfConstants > 0 || numberOfLinearCoefficients > 0 || numberOfQuadraticCoefficients > 0) {
            x = RandomNumber.generate(0, 3);
            if (x == 0 && numberOfQuadraticCoefficients > 0) {
                sign = determineSign(this.quadraticCoefficients[numberOfQuadraticCoefficients-1]);
                if (firstSign) {
                    firstSign = false;
                    if (sign == '+') {
                        System.out.print(" ");
                    } else {
                        System.out.print(" " + sign + " ");
                    }
                } else {
                    System.out.print(" " + sign + " ");
                }
                if (sign == '-') {
                    System.out.print((this.quadraticCoefficients[numberOfQuadraticCoefficients-1] * (-1)) + "x^2");
                } else if (sign == '+') {
                    System.out.print(this.quadraticCoefficients[numberOfQuadraticCoefficients-1] + "x^2");
                }
                rightSide += this.quadraticCoefficients[numberOfQuadraticCoefficients-1]* (int) Math.pow(this.quadraticSolution, 2);
                numberOfQuadraticCoefficients--;
            } else if (x == 1 && numberOfLinearCoefficients > 0){
                sign = determineSign(getLinearCoefficients()[numberOfLinearCoefficients-1]);
                if (firstSign) {
                    firstSign = false;
                    if (sign == '+') {
                        System.out.print(" ");
                    } else {
                        System.out.print(" " + sign + " ");
                    }
                } else {
                    System.out.print(" " + sign + " ");
                }
                if (sign == '-') {
                    System.out.print((getLinearCoefficients()[numberOfLinearCoefficients-1] * (-1)) + "x");
                } else if (sign == '+') {
                    System.out.print(getLinearCoefficients()[numberOfLinearCoefficients-1] + "x");
                }
                rightSide += getLinearCoefficients()[numberOfLinearCoefficients-1]*getLinearSolution();
                numberOfLinearCoefficients--;
            } else if (x == 2 && numberOfConstants > 0) {
                sign = determineSign(getConstants()[numberOfConstants-1]);
                if (firstSign) {
                    firstSign = false;
                    if (sign == '+') {
                        System.out.print(" ");
                    } else {
                        System.out.print(" " + sign + " ");
                    }
                } else {
                    System.out.print(" " + sign + " ");
                }
                if (sign == '-') {
                    System.out.print((getConstants()[numberOfConstants-1] * (-1)));
                } else if (sign == '+') {
                    System.out.print(getConstants()[numberOfConstants-1]);
                }
                rightSide += getConstants()[numberOfConstants-1];
                numberOfConstants--;
            }
        }
        System.out.println(" = " + rightSide);
        findSecondSolution(rightSide);
        //System.out.println("x1: " + this.quadraticSolution + ", x2: " + this.secondSolution);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj.getClass().equals(double[].class))) {
            return false;
        }

        double[] solutions = (double[]) obj;
        double[] thisSolutions = new double[2];
        thisSolutions[0] = this.quadraticSolution;
        thisSolutions[1] = this.secondSolution;
        Arrays.sort(solutions);
        Arrays.sort(thisSolutions);
        return Arrays.equals(solutions, thisSolutions);
    }
}

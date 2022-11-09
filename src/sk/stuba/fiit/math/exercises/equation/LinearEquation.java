package sk.stuba.fiit.math.exercises.equation;

import sk.stuba.fiit.math.RandomNumber;

public class LinearEquation {
    private final int LIMIT_SOLUTION_VALUE = 50;
    private final int LIMIT_COEFFICIENT_COUNT = 10;
    private final int LIMIT_COEFFICIENT_VALUE = 20;
    private int linearSolution;
    private int[] constants;
    private int[] linearCoefficients;

    public int getLinearSolution() {
        return linearSolution;
    }

    public int[] getConstants() {
        return constants;
    }

    public int[] getLinearCoefficients() {
        return linearCoefficients;
    }

    public void generate() {
        do {
            this.linearSolution = RandomNumber.generate(-LIMIT_SOLUTION_VALUE, LIMIT_SOLUTION_VALUE);
        } while(this.linearSolution == 0);
        this.constants = new int[RandomNumber.generate(0, LIMIT_COEFFICIENT_COUNT)];
        this.linearCoefficients = new int[RandomNumber.generate(0, LIMIT_COEFFICIENT_COUNT)];
        generateLinearCoefficients();
        generateConstants();
    }

    public void generateLinearCoefficients() {
        for (int i = 0; i < this.linearCoefficients.length; i++) {
            do {
                this.linearCoefficients[i] = RandomNumber.generate(-LIMIT_COEFFICIENT_VALUE, LIMIT_COEFFICIENT_VALUE);
            } while (this.linearCoefficients[i] == 0);
        }
    }

    public void generateConstants() {
        for (int i = 0; i < this.constants.length; i++) {
            do {
                this.constants[i] = RandomNumber.generate(-LIMIT_COEFFICIENT_VALUE, LIMIT_COEFFICIENT_VALUE);
            } while (this.constants[i] == 0);
        }
    }

    public char determineSign(int number) {
        return (number >= 0) ? '+' : '-';
    }

    public void print() {
        if (this.linearCoefficients == null || this.constants == null) {
            return;
        }
        int numberOfConstants = this.constants.length;
        int numberOfLinearCoefficients = this.linearCoefficients.length;
        int rightSide = 0;
        boolean x;
        char sign = '0';
        while (numberOfConstants > 0 || numberOfLinearCoefficients > 0) {
            x = RandomNumber.generate(-1, 1) < 0;
            if (x && numberOfLinearCoefficients > 0) {
                sign = determineSign(this.linearCoefficients[numberOfLinearCoefficients-1]);
                System.out.print(" " + sign + " ");
                if (sign == '-') {
                    System.out.print((this.linearCoefficients[numberOfLinearCoefficients-1] * (-1)) + "x");
                } else if (sign == '+') {
                    System.out.print(this.linearCoefficients[numberOfLinearCoefficients-1] + "x");
                }
                rightSide += this.linearCoefficients[numberOfLinearCoefficients-1]*this.getLinearSolution();
                numberOfLinearCoefficients--;
            } else if (numberOfConstants > 0){
                sign = determineSign(this.constants[numberOfConstants-1]);
                System.out.print(" " + sign + " ");
                if (sign == '-') {
                    System.out.print((this.constants[numberOfConstants-1] * (-1)));
                } else if (sign == '+') {
                    System.out.print(this.constants[numberOfConstants-1]);
                }
                rightSide += this.constants[numberOfConstants-1];
                numberOfConstants--;
            }
        }
        System.out.println(" = " + rightSide);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj.getClass().equals(Integer.class))) {
            return false;
        }

        Integer integer = (Integer) obj;

        return integer == this.linearSolution;
    }
}

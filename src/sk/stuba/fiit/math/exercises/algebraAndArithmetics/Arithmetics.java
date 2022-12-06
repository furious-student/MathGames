package sk.stuba.fiit.math.exercises.algebraAndArithmetics;

import sk.stuba.fiit.math.RandomNumber;
import sk.stuba.fiit.math.exercises.IExercisable;

public class Arithmetics implements IExercisable {
    private int a;
    private int b;
    private char signs[];
    private char sign;
    private double solution;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public char[] getSigns() {
        return signs;
    }

    public void setSigns(char[] signs) {
        this.signs = signs;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public double getSolution() {
        return solution;
    }

    public void setSolution(double solution) {
        this.solution = solution;
    }

    protected void generateAB() {
        this.a = RandomNumber.generate(-100, 100);
        this.b = RandomNumber.generate(-100, 100);
    }

    protected void addition() {
        this.solution = this.a + this.b;
    }

    protected void subtraction() {
        this.solution = this.a - this.b;
    }

    protected void initializeSigns() {
        this.signs = new char[2];
        this.signs[0] = '+';
        this.signs[1] = '-';
    }

    // ============================== OVERRIDDEN METHODS  ======================================
    @Override
    public void generate() {
        generateAB();
        initializeSigns();
        this.sign = this.signs[RandomNumber.generate(0,2)];
        switch (this.sign) {
            case '+' -> addition();
            case '-' -> subtraction();
            default -> {
            }
        }
    }

    @Override
    public void print() {
        System.out.print(this.a + " " + this.sign);
        if (this.b < 0) {
            System.out.print(" (" + this.b + ") = ");
        } else {
            System.out.print(" " + this.b + " = ");
        }

        System.out.println("?");
    }
    @Override
    public boolean equals(Object obj) {
        if (!(obj.getClass().equals(Double.class))) {
            return false;
        }

        Double decimal = (Double) obj;

        return decimal == this.solution;
    }
}

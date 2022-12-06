package sk.stuba.fiit.math.exercises.algebraAndArithmetics;

import sk.stuba.fiit.math.RandomNumber;

import java.text.DecimalFormat;

public class Algebra extends Arithmetics {

    private void multiplication() {
        super.setSolution(super.getA() * super.getB());
    }

    private void division() {
        super.setSolution((double) super.getA() / super.getB());
    }


    // ============================== OVERRIDDEN METHODS  ======================================
    @Override
    public void generate() {
        generateAB();
        initializeSigns();
        super.setSign(super.getSigns()[RandomNumber.generate(0,4)]);
        switch (super.getSign()) {
            case '+' -> super.addition();
            case '-' -> super.subtraction();
            case '*' -> multiplication();
            case '/' -> division();
            default -> {
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        super.setSolution(Double.parseDouble(df.format(super.getSolution()).replace(',', '.')));
    }

    @Override
    public void initializeSigns() {
        super.setSigns(new char[4]);
        super.getSigns()[0]= '+';
        super.getSigns()[1]= '-';
        super.getSigns()[2]= '*';
        super.getSigns()[3]= '/';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj.getClass().equals(Double.class))) {
            return false;
        }

        Double decimal = (Double) obj;
        return decimal == super.getSolution();
    }
}

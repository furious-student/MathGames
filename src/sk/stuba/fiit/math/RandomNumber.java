package sk.stuba.fiit.math;

import java.text.DecimalFormat;

public class RandomNumber {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static int generate(int min, int max) {
        return (int) (Math.random() * (max-min)) + min;
    }

    public static double generate(double min, double max) {
        return Double.parseDouble(df.format((Math.random() * (max-min)) + min).replace(',', '.'));
    }
}

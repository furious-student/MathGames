package sk.stuba.fiit.math.theory;

public class EquationFormula extends MathFormulas {
    public void printFormula() {
        super.printFormula("Linear equation");
        System.out.println("Solve whole equation by doing equivalent operations on its both sides till x = a, where a belongs to R");
        super.printFormula("Quadratic equation");
        System.out.println("Solve whole equation by doing equivalent operations on its both sides till ax^2+bx+c = 0, where a,b,c belong to whole numbers. " +
                "Then use the formula: x1,2 = (-b+-sqrt(b^2-4*a*c)) / (2*a)");
    }
}

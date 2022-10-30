package sk.stuba.fiit;

public class TestMain {
    public static void main(String[] args) {

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
    }
}

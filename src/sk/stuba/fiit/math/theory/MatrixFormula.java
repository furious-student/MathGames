package sk.stuba.fiit.math.theory;

public class MatrixFormula extends MathFormulas {

    public void printFormula() {
        super.printFormula("Matrix addition");
        System.out.println("Given matrix A = (aij)mxn and matrix B = (bij)mxn, the formula looks like this: " +
                            "cij = aij + bij");
        super.printFormula("Matrix multiplication");
        System.out.println("Given matrix A = (aij)mxn and matrix B = (bij)nxm, the formula looks like this: " +
                "c11 = a1j*bi1 + a2j*bi2 + ... + anj*bin");
    }
}

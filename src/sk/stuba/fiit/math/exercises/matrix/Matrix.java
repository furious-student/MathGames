package sk.stuba.fiit.math.exercises.matrix;

import sk.stuba.fiit.math.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Matrix {
    private final int MAX_LIMIT = 100;
    private final int MIN_LIMIT = -100;
    private int sizeM;
    private int sizeN;
    private List<List<Integer>> body;

    public Matrix(int sizeM, int sizeN) {
        this.sizeM = sizeM;
        this.sizeN = sizeN;
        this.body = new ArrayList<>();
        for (int i = 0; i < sizeM; i++) {
            body.add(new ArrayList<>(sizeN));
        }
    }

    // ============================== GETTERS AND SETTERS ======================================
    public int getSizeM() {
        return sizeM;
    }

    public void setSizeM(int sizeM) {
        this.sizeM = sizeM;
    }

    public int getSizeN() {
        return sizeN;
    }

    public void setSizeN(int sizeN) {
        this.sizeN = sizeN;
    }

    public List<List<Integer>> getBody() {
        return body;
    }

    public void setBody(List<List<Integer>> body) {
        this.body = body;
    }
    // ====================================================================

    public void generate(final int minElement,final int maxElement) {
        if (isEmpty()) {
            for (int i = 0; i < this.sizeM; i++) {
                for (int j = 0; j < sizeN; j++) {
                    body.get(i).add(RandomNumber.generate(minElement, maxElement));
                }
            }
        } else {
            regenerate(minElement, maxElement);
        }

    }

    public void generate() {
        if (isEmpty()) {
            for (int i = 0; i < this.sizeM; i++) {
                for (int j = 0; j < sizeN; j++) {
                    body.get(i).add(RandomNumber.generate(this.MIN_LIMIT, this.MAX_LIMIT));
                }
            }
        } else {
            regenerate();
        }
    }

    public void generateZeroMatrix() {
        if (isEmpty()) {
            for (int i = 0; i < this.sizeM; i++) {
                for (int j = 0; j < sizeN; j++) {
                    body.get(i).add(0);
                }
            }
        } else {
            for (int i = 0; i < this.sizeM; i++) {
                for (int j = 0; j < sizeN; j++) {
                    body.get(i).set(j, 0);
                }
            }
        }
    }

    private void regenerate(final int minElement,final int maxElement) {
        for (int i = 0; i < this.sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                body.get(i).set(j,RandomNumber.generate(minElement, maxElement));
            }
        }
    }

    private void regenerate() {
        for (int i = 0; i < this.sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                body.get(i).set(j,RandomNumber.generate(this.MIN_LIMIT, this.MAX_LIMIT));
            }
        }
    }

    public void print() {
        if (this.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                if (body.get(i).get(j) >= 0) {
                    if (body.get(i).get(j) < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                } else if (body.get(i).get(j) > -10) {
                    System.out.print(" ");
                }
                System.out.print(body.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void print(final Matrix matrix) {
        if (matrix.isEmpty()) {
            return;
        }
        int sizeM = matrix.getSizeM();
        int sizeN = matrix.getSizeN();
        List<List<Integer>> body = matrix.getBody();
        for (int i = 0; i < sizeM; i++) {
            for (int j = 0; j < sizeN; j++) {
                if (body.get(i).get(j) > 0) {
                    if (body.get(i).get(j) < 10) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                } else if (body.get(i).get(j) > -10) {
                    System.out.print(" ");
                }
                System.out.print(body.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private boolean isEmpty() {
        return this.body.get(0).isEmpty();
    }

    private Matrix create(final int sizeM,final int sizeN) {
        Matrix newMatrix = new Matrix(sizeM, sizeN);
        newMatrix.generateZeroMatrix();
        return newMatrix;
    }

    public Matrix add(final Matrix matrix) {
        if (this.sizeN != matrix.sizeN || this.sizeM != matrix.sizeM) {
            return null;
        }
        Matrix sumMatrix = create(this.sizeM, this.sizeN);

        for (int i = 0; i < this.sizeM; i++) {
            for (int j = 0; j < this.sizeN; j++) {
                sumMatrix.getBody().get(i).set(j, this.body.get(i).get(j) + matrix.getBody().get(i).get(j));
            }
        }
        return sumMatrix;
    }

    public Matrix multiply(final Matrix matrix) {
        if (this.sizeN != matrix.sizeM) {
            return null;
        }
        Matrix productMatrix = create(this.sizeM, matrix.sizeN);

        int element = 0;
        for (int i = 0; i < this.sizeM; i++) {
            for (int j = 0; j < matrix.sizeN; j++) {
                for (int k = 0; k < this.sizeN; k++) {
                    element += this.body.get(i).get(k) * matrix.getBody().get(k).get(j);
                }
                productMatrix.getBody().get(i).set(j, element);
                element = 0;
            }
        }
        return productMatrix;
    }

    // ============================== OVERRIDDEN METHODS  ======================================

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || this.getClass() != o.getClass()) {return false;}
        Matrix matrix = (Matrix) o;
        if (this.sizeM != matrix.sizeM || this.sizeN != matrix.sizeN) {return false;}

        for (int i = 0; i < this.sizeM; i++) {
            for (int j = 0; j < this.sizeN; j++) {
                if (!Objects.equals(this.body.get(i).get(j), matrix.getBody().get(i).get(j))) {
                    return false;
                }
            }
        }

        return true;
    }

}

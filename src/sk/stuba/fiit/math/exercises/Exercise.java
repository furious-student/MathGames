package sk.stuba.fiit.math.exercises;

public abstract class Exercise {
    private boolean isCorrect;

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        this.isCorrect = correct;
    }

    // ============================= UTILITY PRINT FUNCTIONS =============================
    public final void printKudos() {
        System.out.println("Kudos! Your solution is correct.");
    }

    public final void printError() {
        System.out.println("Better luck next time! your solution was incorrect.");
    }

    public abstract boolean generateExercise(boolean printOptions);
    public abstract void printOptions();
    public abstract boolean isSolutionCorrect();
    public abstract void getUserSolution();
}

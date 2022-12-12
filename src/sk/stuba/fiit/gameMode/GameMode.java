package sk.stuba.fiit.gameMode;

import sk.stuba.fiit.math.exercises.Exercise;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public abstract class GameMode {
    private String name;

    private ArrayList<Exercise> exercises;
    private double maxPoints;
    private double points;
    private int time;
    private Timer timer = null;

    public GameMode(String name) {
        this.name = name;
        this.exercises = new ArrayList<>();
        this.maxPoints = 0;
        this.points = 0;
        this.time = 0;
    }

    public abstract void printGameModeMenu();
    public abstract void play(ArrayList<Integer> typeOfExercises);

    public double getPoints() {
        return points;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public double getMaxPoints() {
        return maxPoints;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setMaxPoints(double maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public void clearStats() {
        this.points = 0;
        this.time = 0;
    }

    protected void addPoints(int points) {
        this.points += points;
    }

    protected void removePoints(double points) {
        this.points -= points;
    }

    public void startTime() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time++;
            }
        }, 100, 1000);
    }

    public void stopTime() {
        if (this.timer != null) {
            this.timer.cancel();
        }
    }

    public static void printGameModes() {
        System.out.println(
                """
                        Choose Game Mode:
                        \t0 -> Go Back
                        \t1 -> QuickMathSolver
                        \t2 -> TheTrueSolver
                        \t3 -> LordOfMath
                        \t4 -> Help"""
        ); // Eclipse?
    }

    public static void printHelp() {
        System.out.println(
                """
                        QuickMathSolver:
                            - Multiple choice questions
                            - Correct answer: +1 point
                            - Incorrect answer: -0.2 point
                        TheTrueSolver:
                            - Open questions
                            - Correct answer: +2 point
                            - Incorrect answer: -0.5 point
                        LordOfMath:
                            - Open questions
                            - Correct answer: +1 point
                            - Incorrect answer: game ends
                        """
        ); // Eclipse?
    }

    @Override
    public boolean equals(Object obj) {
        GameMode gameMode = (GameMode) obj;
        return this.name.equals(gameMode.getName());
    }


}

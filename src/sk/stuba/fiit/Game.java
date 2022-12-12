package sk.stuba.fiit;

import sk.stuba.fiit.gameMode.GameMode;
import sk.stuba.fiit.gameMode.LordOfMath;
import sk.stuba.fiit.gameMode.QuickMathSolver;
import sk.stuba.fiit.gameMode.TheTrueSolver;
import sk.stuba.fiit.math.exercises.algebraAndArithmetics.Arithmetics;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static Game instance = null;
    private final Player player;
    private final List<GameMode> gameModes = new ArrayList<>();
    private GameMode currentGameMode;

    private Game(Player player) {
        this.player = player;
        GameMode quickMathSolver = new QuickMathSolver();
        this.gameModes.add(quickMathSolver);
        GameMode theTrueSolver = new TheTrueSolver();
        this.gameModes.add(theTrueSolver);
        GameMode lordOfMath = new LordOfMath();
        this.gameModes.add(lordOfMath);
    }

    public static Game getInstance(Player player) {
        if(instance == null) {
            instance = new Game(player);
        }
        return instance;
    }

    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    public void initialize() {
        System.out.println("Welcome in the Game!");
        GameMode.printGameModes();
    }

    public void start() {
        currentGameMode.printGameModeMenu();
        // game played here
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int numberOfQuestions = 0;
        ArrayList<Integer> exerciseTypes = new ArrayList<>();
        try {
            for (int i = 0; i < s.length; i++) {
                exerciseTypes.add(Integer.parseInt(s[i]));
            }
        } catch (Exception e) {
            System.out.println("Invalid option(s)");
            return;
        }
        currentGameMode.startTime();
        currentGameMode.play(exerciseTypes);
    }

    public void end() {
        if (this.player.getHighScoreMode() == null || this.player.getHighScoreMode().getMaxPoints() < this.currentGameMode.getPoints()) {
            this.player.setHighScoreMode(this.currentGameMode);
        }

        if (this.currentGameMode.getPoints() > this.currentGameMode.getMaxPoints()) {
            this.currentGameMode.setMaxPoints(this.currentGameMode.getPoints());
        }

        this.currentGameMode.stopTime();
        System.out.println("Game Over");
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Points acquired in " + this.currentGameMode.getName() + ": " + df.format(this.currentGameMode.getPoints()));
        printTime();
        System.out.println("Highscore acquired in this mode: " + this.currentGameMode.getName() + ": " + df.format(this.currentGameMode.getMaxPoints()));
        System.out.println("Overall highscore acquired in mode: " + this.player.getHighScoreMode().getName() + ": " + df.format(this.player.getHighScoreMode().getMaxPoints()));
        this.currentGameMode.clearStats();
    }
    public void help() {
        GameMode.printHelp();
    }

    public void switchModes(String name) {
        int index = -1;
        for (int i = 0; i < this.gameModes.size(); i++) {
            if (this.gameModes.get(i).getName().equals(name)) {
                index = i;
            }
        }
        this.currentGameMode = (index >= 0) ?  this.gameModes.get(index) : null;
    }

    private void printTime() {
        int time = this.currentGameMode.getTime(); // time played in seconds
        System.out.println("Time played: " + time / 60 + " minute(s), " + time % 60 + " second(s)");
    }
}

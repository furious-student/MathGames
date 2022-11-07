package sk.stuba.fiit;

import sk.stuba.fiit.gameMode.GameMode;
import sk.stuba.fiit.gameMode.LordOfMath;
import sk.stuba.fiit.gameMode.QuickMathSolver;
import sk.stuba.fiit.gameMode.TheTrueSolver;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private final GameMode quickMathSolver = new QuickMathSolver();
    private final GameMode theTrueSolver = new TheTrueSolver();
    private final GameMode lordOfMath = new LordOfMath();
    private List<GameMode> gameModes = new ArrayList<>();
    private GameMode currentGameMode;

    public Game(Player player) {
        this.player = player;
        this.gameModes.add(this.quickMathSolver);
        this.gameModes.add(this.theTrueSolver);
        this.gameModes.add(this.lordOfMath);
    }

    public GameMode getCurrentGameMode() {
        return currentGameMode;
    }

    public void initialize() {
        System.out.println("Welcome in the Game!");
        GameMode.printGameModes();
    }


    public void play() {
        currentGameMode.printGameModeMenu();
    }

    public void start() {
        currentGameMode.startTime();
    }

    public void end() {
        if (this.player.getHighScoreMode() == null || this.player.getHighScoreMode().getPoints() > this.currentGameMode.getPoints()) {
            this.player.setHighScoreMode(this.currentGameMode);
        }

        if (this.currentGameMode.getPoints() > this.currentGameMode.getMaxPoints()) {
            this.currentGameMode.setMaxPoints(this.currentGameMode.getPoints());
        }
        this.currentGameMode.clearStats();
        this.currentGameMode.stopTime();
        System.out.println("Game Over");
        System.out.println("Points acquired in " + this.currentGameMode.getName() + ": " + this.currentGameMode.getPoints());
        System.out.println("Time played: " + + this.currentGameMode.getTime());
        System.out.println("Highscore acquired in this mode: " + this.currentGameMode.getName() + ": " + this.currentGameMode.getPoints());
        System.out.println("Overall highscore acquired in mode: " + this.player.getHighScoreMode().getName() + ": " + this.player.getHighScoreMode().getPoints());
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
}

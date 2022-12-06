package sk.stuba.fiit;

import sk.stuba.fiit.gameMode.GameMode;

public class Player {
    private String nickName;
    private GameMode highScoreMode;

    public Player(String nickName) {
        this.nickName = nickName;
        this.highScoreMode = null;
    }

    public Player() {
        this("Guest007");
    }

    public String getNickName() {
        return nickName;
    }

    public GameMode getHighScoreMode() {
        return highScoreMode;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setHighScoreMode(GameMode highScoreMode) {
        this.highScoreMode = highScoreMode;
    }
}

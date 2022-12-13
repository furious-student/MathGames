package sk.stuba.fiit.utility;

public class MainMenu extends Menu{
    public MainMenu(String gameMode) {
        super(gameMode);
    }

    @Override
    public void printMenu() {
        System.out.println("Welcome in this wonderful math world traveler!");
    }
}

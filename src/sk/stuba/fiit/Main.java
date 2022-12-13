package sk.stuba.fiit;

import sk.stuba.fiit.math.theory.EquationFormula;
import sk.stuba.fiit.math.theory.MatrixFormula;
import sk.stuba.fiit.utility.MainMenu;
import sk.stuba.fiit.utility.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new MainMenu(null);
        MainMenu mainMenu = null;
        // Downcasting
        if (menu instanceof MainMenu) {
            mainMenu = (MainMenu) menu;
        }

        Player player = new Player();
        Game game = Game.getInstance(player);

        int option;
        mainMenu.printMenu();
        do {
            printHeader(player);
            printMainMenu();
            option = getUserNumberInput();

            switch (option) {
                case 0 -> {}
                case 1 -> {
                    System.out.print("Enter new nickname: ");
                    player.setNickName(getUserStringInput());
                }
                case 2 -> {
                    EquationFormula mathFormula = new EquationFormula();
                    mathFormula.printFormula();
                    MatrixFormula matrixFormula = new MatrixFormula();
                    matrixFormula.printFormula();
                }
                case 3 -> System.out.println("MathTopics included in this application: Arithmetics, Algebra, Linear equations, Quadratic equations, Matrices");
                case 4 -> {
                    option = -1;
                    String gameMode = null;
                    while (option != 0) {
                        game.initialize();
                        option = getUserNumberInput();
                        switch (option) {
                            case 0 -> gameMode = null;
                            case 1 -> gameMode = "QuickMathSolver";
                            case 2 -> gameMode = "TheTrueSolver";
                            case 3 -> gameMode = "LordOfMath";
                            case 4 -> game.help();
                            case -1 -> {}
                            default ->
                                    System.out.println("Option \"" + option + "\" is not recognized as a valid option");
                        }
                        if (gameMode != null) {
                            game.switchModes(gameMode);
                            game.start();
                            // playing game
                            game.end();
                            gameMode = null;
                            System.out.println();
                        }
                    }
                    option = -1;
                }
                case -1 -> {}
                default -> {
                    System.out.println("Option \"" + option + "\" is not recognized as a valid option");
                }
            }
        } while (option != 0);
    }

    private static void printHeader(Player player) {
        System.out.println("Playing for: " + player.getNickName()); // Header
    }

    private static void printMainMenu() {
        // Available options:
        System.out.println(
                """
                        Choose option:
                        \t0 -> End Application
                        \t1 -> Change Nickname
                        \t2 -> Math Formulas
                        \t3 -> Math Topics
                        \t4 -> Play Game"""
        );
    }

    private static int getUserNumberInput() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String input = scanner.nextLine();
        try {
            option = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Option \"" + input + "\" is not recognized as a valid input");
        }

        return option;
    }

    private static String getUserStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}

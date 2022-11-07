package sk.stuba.fiit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("John");
        Game game = new Game(player);

        int option;

        do {
            printHeader(player);
            printMainMenu();
            option = getUserNumberInput();

            switch (option) {
                case 0 -> {
                    break;
                }
                case 1 -> {
                    System.out.print("Enter new nickname: ");
                    player.setNickName(getUserStringInput());
                }
                case 2 -> System.out.println("MathFormulas");
                case 3 -> System.out.println("MathTopics");
                case 4 -> {
                    option = -1;
                    String gameMode = null;
                    while (option != 0) {
                        game.initialize();
                        option = getUserNumberInput();
                        switch (option) {
                            case 0:
                                gameMode = null;
                                break;
                            case 1:
                                gameMode = "QuickMathSolver";
                                break;
                            case 2:
                                gameMode = "TheTrueSolver";
                                break;
                            case 3:
                                gameMode = "LordOfMath";
                                break;
                            case 4:
                                game.help();
                                break;
                            default:
                                System.out.println("Option \"" + option + "\" is not recognized as a valid option");
                        }
                        if (gameMode != null) {
                            game.switchModes(gameMode);
                            game.play();
                            game.start();
                            // playing game
                            game.end();
                            System.out.println();
                        }
                    }
                    option = -1;
                } default -> {
                    System.out.println("Option \"" + option + "\" is not recognized as a valid option");
                    printMainMenu();
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
        ); // Eclipse?
    }

    private static int getUserNumberInput() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
        } else {
            scanner.nextLine();
        }
        return option;
    }

    private static String getUserStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}

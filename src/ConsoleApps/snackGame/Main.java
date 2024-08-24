package ConsoleApps.snackGame;

import java.util.Scanner;

public class Main {
    static Scanner get = new Scanner(System.in);
    public static void main(String[] args) {
        SnackGame game = new SnackGame();
        boolean gameOn = true;

        while(gameOn && game.isFoodAvailable()) {
            game.printBoard();
            System.out.println("Enter Direction [U, R, L, D]");
            char option = get.next().charAt(0);

            switch(option) {
                case 'U' : gameOn = game.move(-1, 0); break;
                case 'R' : gameOn = game.move(0, 1); break;
                case 'L' : gameOn = game.move(0, -1); break;
                case 'D' : gameOn = game.move(1, 0); break;
                default : System.out.println("Enter valid input");
            }
        }
        game.printBoard();
        if(game.isFoodAvailable()) {
            System.out.println("Game Over");
        } else {
            System.out.println("You won");
        }
    }
}

package bullscows;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preparing
        UserInterface ui = new UserInterface(scanner);
        Game game = new Game(ui);
        game.preparing();

        //game-loop with UserInterface interactions
        if (game.isGameRunning()) {
            game.play();
        }

    }
}


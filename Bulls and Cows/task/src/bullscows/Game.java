package bullscows;
public class Game {
    private final UserInterface ui;
    private SecretNumber secretNumber;

    private String userAnswer;
    int bulls;

    private int turn;
    Integer length;
    Integer symbols;

    public boolean isGameRunning() {
        return gameRunning;
    }

    private boolean gameRunning = true;
    public Game(UserInterface ui) {
        this.ui = ui;
        turn = 1;
    }

    public void preparing() {
        // User set Code Length and Symbols
        length = ui.askCodeLength();
        if (length == null) {
            gameRunning = false;
            return;
        }
        symbols = ui.askCodeSymbols();
        if (symbols == null) {
            gameRunning = false;
            return;
        }

        if (symbols < length) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + symbols + " unique symbols.");
            gameRunning = false;
            return;
        }

        // Set SecretCode
        this.secretNumber = new SecretNumber(length, symbols);
        secretNumber.printCodePreparing();
    }
    public void play() {
        // start message
        System.out.println(startMessage());
        // loop: turn n: -> userAnswer -> printGrade
        while (gameRunning) {
            // display turn number
            System.out.printf("Turn %d:\n", turn);

            // user input & check user input
            userAnswer = ui.userAnswer(length);
            //// if userAnswer is invalid (null) -> break loop
            if (userAnswer == null) {
                System.out.println("Error: Invalid Answer");
                break;
            }

            // if answer valid -> grade
            System.out.println(grade());

            // if 4 bulls: win message and break, else turn+1
            if (bulls == length) {
                System.out.println(winMessage());
                break;
            } else {
                turn++;
            }
        }
    }

    private String startMessage() {
        return "Okay, let's start a game!";
    }

    private String winMessage() {
        return "Congratulations! You guessed the secret code.";
    }

    private String grade() {
            String secretCode = secretNumber.getSecretCode();
            bulls = 0;
            int cows = 0;
            for (int i = 0; i < userAnswer.length(); i++) {
                if (userAnswer.charAt(i) == secretCode.charAt(i)) {
                    bulls++;
                } else if (secretCode.contains(""+ userAnswer.charAt(i))) {
                    cows++;
                }
            }
            StringBuilder string = new StringBuilder();
            string.append("Grade: ");
            if (bulls == 0 && cows == 0) {
                string.append("None");
            } else {
                if (bulls > 0) {
                    string.append(bulls).append(" bull(s)");
                }

                if (bulls > 0 && cows > 0) {
                    string.append(" and ");
                }

                if (cows > 0) {
                    string.append(cows).append(" cow(s)");
                }
            }
            string.append(". ");
            return String.valueOf(string);
    }
}

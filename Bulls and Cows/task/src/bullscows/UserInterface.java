package bullscows;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;


    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }
    public Integer askCodeLength(){
        // Ask length of secretCode
        System.out.println("Input the length of the secret code:");

        String lengthInput = scanner.nextLine();
        if (isNotValidDigit(lengthInput)) {
            return null;
        }
        if (Integer.parseInt(lengthInput) > 36) {
            System.out.println("Error: it's not possible to generate a code with a length of " + lengthInput + " with" +
                    " unique symbols.");
            return null;
        }

        return Integer.parseInt(lengthInput);
    }

    public Integer askCodeSymbols(){
        // Ask symbols of SecretCode
        System.out.println("Input the number of possible symbols in the code:");
        String symbolInput = scanner.nextLine();
        if (isNotValidDigit(symbolInput)) {
            return null;
        }
        if (Integer.parseInt(symbolInput) > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is" +
                    " 36 (0-9, a-z).");
            return null;
        }
        return Integer.parseInt(symbolInput);
    }

    private boolean isNotValidDigit(String str) {
        if (!str.matches("[1-9]\\d*")) {
            System.out.println("Error: \"" + str + "\" isn't a valid number.");
            return true;
        }
        return false;
    }

    public String userAnswer(int length) {
        String userAnswer = scanner.nextLine();

        // check
        if (userAnswer.matches("[0-9a-z]{" + length + "}")) {
            return userAnswer;
        }
        return null;
    }
}

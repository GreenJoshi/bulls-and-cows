package bullscows;

import java.util.Random;
import java.util.Scanner;

public class SecretNumber {

    private final int length;
    private final int symbols;
    private String secretCode = "";
    private final String characters = "0123456789abcdefghijklmnopqrstuvwxyz";

    public SecretNumber(int length, int symbols) {
        this.length = length;
        this.symbols = symbols;

        StringBuilder secretToBuild = new StringBuilder();

        while (secretToBuild.length() < length) {
            Random r = new Random();
            int randomInt = r.nextInt(0,symbols);


            char c = characters.charAt(randomInt);

            if (secretToBuild.toString().contains(c + "")) {
                continue;
            }

            secretToBuild.append(c);

        }

        secretCode = secretToBuild.toString();

    }

    public void printCodePreparing() {
        System.out.print("The secret is prepared: " + "*".repeat(Math.max(0, length)));
        System.out.printf(" (0-9, a-%s).\n",characters.charAt(symbols-1) );
    }


    public String getSecretCode() {
        return secretCode;
    }

}


import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        StringBuilder sb = new StringBuilder(message);
        for (int i = 0; i < sb.length();i = i+2) {
            String s = String.valueOf(sb.charAt(i));
            sb.replace(i,i+1,s.toUpperCase());
        }
        return sb.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}
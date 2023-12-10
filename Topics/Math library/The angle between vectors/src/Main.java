import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        double angle;

        // cos alpha = ((a1*a2) + (b1*b2)) / Hypothenuse v1 * Hypothenuse v2



        angle = Math.toDegrees(Math.acos(((a1 * a2) + (b1 * b2)) /
                (Math.hypot(a1, b1) * Math.hypot(a2, b2))));

        System.out.println(angle);
    }
}

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d;
        double x1 = 0.0;
        double x2 = 0.0;

        // quadratic equation: ax^2 + bx^2 + c = 0
        // x1,2 = (-b +- sqrt(b²-4ac)) / (2a)

        d = (b*b) - (4*a*c);
        if (d >= 0) {
            if (d == 0) {
                System.out.println((-b)/(2*a));
            } else {
                x1 = (-b+Math.sqrt(d))/(2*a);
                x2 = ((-b-Math.sqrt(d))/(2*a));
            }
        }

        if (x1 <= x2) {
            System.out.println(x1 + " " + x2);
        } else {
            System.out.println(x2 + " " + x1);
        }
    }
}
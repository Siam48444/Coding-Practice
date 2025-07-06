public class MiniCalculator {
    public static void main(String[] args) {
        add(5, 6);
        subtract(5, 6);
        multiply(5, 6);
        divide(5, 6);
        modulo(5, 6);
    }


    // Adds two integers
    public static void add(int a, int b) {
        System.out.printf("%d + %d = %d %n", a, b, a + b);
    }


    // Subtracts second integer from the first one
    public static void subtract(int a, int b) {
        System.out.printf("%d - %d = %d %n", a, b, a - b);
    }


    // Multiplies two integers
    public static void multiply(int a, int b) {
        System.out.printf("%d * %d = %d %n", a, b, a * b);
    }


    // Divides two valid integers
    public static void divide(int a, int b) {
        if (b != 0) {
            double x = a;
            double y = b;
            System.out.printf("%d / %d = %.3f %n", a, b, x / y);
        }
        else {
            System.out.println("Division by zero is not allowed.");
        }
    }


    // Finds the remainder when the first integer is divided by the second one
    public static void modulo(int a, int b) {
        if (b != 0) {
            System.out.printf("%d %% %d = %d %n", a, b, a % b);
        }
        else {
            System.out.println("Division by zero is not allowed.");
        }
    }
}
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----- Scientific Calculator Menu -----");
            System.out.println("1. Addition (+, handles multiple numbers)");
            System.out.println("2. Subtraction (-, handles multiple numbers)");
            System.out.println("3. Multiplication (*, handles multiple numbers)");
            System.out.println("4. Division (/)");
            System.out.println("5. Square (x^2)");
            System.out.println("6. Exponential (e^x)");
            System.out.println("7. Power (x^y)");
            System.out.println("8. Trigonometric Functions");
            System.out.println("9. Logarithms (log)");
            System.out.println("10. Number System Conversion");
            System.out.println("11. Unit Conversions");
            System.out.println("12. Scientific Constants");
            System.out.println("0. Exit");
            System.out.print("Choose an option (0-12): ");

            int choice = readIntegerInput();

            switch (choice) {
                case 1: performAddition(); break;
                case 2: performSubtraction(); break;
                case 3: performMultiplication(); break;
                case 4: performDivision(); break;
                case 5: performSquare(); break;
                case 6: performExponential(); break;
                case 7: performPower(); break;
                case 8: performTrigonometry(); break;
                case 9: performLogarithm(); break;
                case 10: performNumberConversion(); break;
                case 11: performUnitConversion(); break;
                case 12: displayScientificConstants(); break;
                case 0:
                    System.out.println("Exiting calculator. Goodbye! 👋");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // --- Safe Input Reader Methods ---

    private static int readIntegerInput() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a whole number: ");
                sc.next(); // Clears the invalid input from the scanner
            }
        }
    }

    private static double readDoubleInput() {
        while (true) {
            try {
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                sc.next(); // Clears the invalid input from the scanner
            }
        }
    }

    // --- Core Calculation Methods ---

    private static void performAddition() {
        System.out.print("How many numbers do you want to add? ");
        int count = readIntegerInput();
        if (count < 2) {
            System.out.println("Error: Please provide at least 2 numbers.");
            return;
        }
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = readDoubleInput();
        }
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        System.out.println("Result: " + sum);
    }

    private static void performSubtraction() {
        System.out.print("How many numbers do you want to subtract? ");
        int count = readIntegerInput();
        if (count < 2) {
            System.out.println("Error: Please provide at least 2 numbers.");
            return;
        }
        System.out.println("Enter numbers in order (e.g., for 100 - 20 - 5, enter 100, then 20, then 5)");
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = readDoubleInput();
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        System.out.println("Result: " + result);
    }

    private static void performMultiplication() {
        System.out.print("How many numbers do you want to multiply? ");
        int count = readIntegerInput();
        if (count < 2) {
            System.out.println("Error: Please provide at least 2 numbers.");
            return;
        }
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = readDoubleInput();
        }
        double product = 1.0;
        for (double num : numbers) {
            product *= num;
        }
        System.out.println("Result: " + product);
    }

    private static void performDivision() {
        System.out.print("Enter the numerator: ");
        double num1 = readDoubleInput();
        System.out.print("Enter the denominator: ");
        double num2 = readDoubleInput();
        if (num2 == 0) {
            System.out.println("Error: Cannot divide by zero.");
        } else {
            System.out.println("Result: " + (num1 / num2));
        }
    }

    private static void performSquare() {
        System.out.print("Enter the number to square: ");
        double num = readDoubleInput();
        System.out.println("Result: " + (num * num));
    }

    private static void performExponential() {
        System.out.print("Enter the exponent for e: ");
        double num = readDoubleInput();
        System.out.println("Result: " + Math.exp(num));
    }

    private static void performPower() {
        System.out.print("Enter the base: ");
        double base = readDoubleInput();
        System.out.print("Enter the exponent: ");
        double exponent = readDoubleInput();
        System.out.println("Result: " + Math.pow(base, exponent));
    }

    private static void performTrigonometry() {
        System.out.println("\n--- Trigonometry Menu ---");
        System.out.println("1. sin(θ)  2. cos(θ)  3. tan(θ)");
        System.out.println("4. arcsin(x)  5. arccos(x)  6. arctan(x)");
        System.out.print("Choose a function: ");
        int choice = readIntegerInput();

        if (choice >= 1 && choice <= 3) {
            System.out.print("Enter the angle in degrees: ");
            double angleDegrees = readDoubleInput();
            double angleRadians = Math.toRadians(angleDegrees);
            double result = 0;
            switch (choice) {
                case 1: result = Math.sin(angleRadians); System.out.println("sin(" + angleDegrees + "°) = " + result); break;
                case 2: result = Math.cos(angleRadians); System.out.println("cos(" + angleDegrees + "°) = " + result); break;
                case 3: result = Math.tan(angleRadians); System.out.println("tan(" + angleDegrees + "°) = " + result); break;
            }
        } else if (choice >= 4 && choice <= 6) {
            System.out.print("Enter the value: ");
            double value = readDoubleInput();
            double result = 0;
            switch (choice) {
                case 4:
                    if (value < -1 || value > 1) { System.out.println("Error: Input for arcsin must be between -1 and 1."); return; }
                    result = Math.toDegrees(Math.asin(value)); System.out.println("arcsin(" + value + ") = " + result + "°"); break;
                case 5:
                    if (value < -1 || value > 1) { System.out.println("Error: Input for arccos must be between -1 and 1."); return; }
                    result = Math.toDegrees(Math.acos(value)); System.out.println("arccos(" + value + ") = " + result + "°"); break;
                case 6:
                    result = Math.toDegrees(Math.atan(value)); System.out.println("arctan(" + value + ") = " + result + "°"); break;
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void performLogarithm() {
        System.out.print("Enter the number: ");
        double number = readDoubleInput();
        System.out.print("Enter the base: ");
        double base = readDoubleInput();
        if (number <= 0 || base <= 0 || base == 1) {
            System.out.println("Error: Invalid input for logarithm. Number and base must be positive, and base cannot be 1.");
            return;
        }
        double result = Math.log(number) / Math.log(base);
        System.out.println("log base " + base + " of " + number + " = " + result);
    }

    private static void performNumberConversion() {
        System.out.print("Enter an integer to convert: ");
        int num = readIntegerInput();
        System.out.println("Binary: " + Integer.toBinaryString(num));
        System.out.println("Octal: " + Integer.toOctalString(num));
        System.out.println("Hexadecimal: " + Integer.toHexString(num).toUpperCase());
    }

    private static void performUnitConversion() {
        System.out.println("\n--- Unit Conversion Menu ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Kilometers to Miles");
        System.out.println("4. Miles to Kilometers");
        System.out.print("Choose a conversion: ");
        int choice = readIntegerInput();

        double value, result;
        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                value = readDoubleInput();
                result = (value * 9 / 5) + 32;
                System.out.println(value + "°C is equal to " + result + "°F.");
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                value = readDoubleInput();
                result = (value - 32) * 5 / 9;
                System.out.println(value + "°F is equal to " + result + "°C.");
                break;
            case 3:
                System.out.print("Enter distance in Kilometers: ");
                value = readDoubleInput();
                result = value / 1.60934;
                System.out.println(value + " km is equal to " + result + " miles.");
                break;
            case 4:
                System.out.print("Enter distance in Miles: ");
                value = readDoubleInput();
                result = value * 1.60934;
                System.out.println(value + " miles is equal to " + result + " km.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void displayScientificConstants() {
        System.out.println("\n--- Common Scientific Constants ---");
        System.out.println("Pi (π): " + Math.PI);
        System.out.println("Euler's Number (e): " + Math.E);
        System.out.println("Speed of Light (c): 299,792,458 m/s");
        System.out.println("Gravitational Constant (G): 6.67430e-11 N(m/kg)²");
        System.out.println("------------------------------------");
    }
}
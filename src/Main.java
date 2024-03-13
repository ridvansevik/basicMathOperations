import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);


    public static int calculateHighestCommonFactor(int number1, int number2) {
        int hcf = 1;
        for (int i = 1; i <= number1 && i <= number2; ++i) {
            if (number1 % i == 0 && number2 % i == 0) {
                hcf = i;
            }
        }
        return hcf;
    }

    public static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void checkPrime() {
        System.out.println("Enter the number to check for primality:");
        int numberToCheck = scanner.nextInt();
        if (isPrime(numberToCheck)) {
            System.out.println(numberToCheck + " is a prime number.");
        } else {
            System.out.println(numberToCheck + " is not a prime number.");
        }
    }

    public static int calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int calculateCombination(int n, int r) {
        int factorialN = calculateFactorial(n);
        int factorialR = calculateFactorial(r);
        int factorialNR = calculateFactorial(n - r);
        return factorialN / (factorialR * factorialNR);
    }

    public static void displayMenu() {
        System.out.println("1. Calculate Highest Common Factor (HCF)");
        System.out.println("2. Check for Prime");
        System.out.println("3. Check if the first number can divide the second number");
        System.out.println("4. Calculate Factorial");
        System.out.println("5. Calculate Combination");
        System.out.println("6. Exit");
    }

    public static void handleHCF() {
        System.out.println("Enter two numbers:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println("HCF of " + num1 + " and " + num2 + " is: " + calculateHighestCommonFactor(num1, num2));
    }

    public static void handleDivisibility() {
        System.out.println("Enter two numbers:");
        int num3 = scanner.nextInt();
        int num4 = scanner.nextInt();
        if (num4 == 0) {
            System.out.println("Cannot divide by zero.");
        } else if (num3 % num4 == 0) {
            System.out.println("Yes, " + num3 + " can divide " + num4 + " without remainder.");
        } else {
            System.out.println("No, " + num3 + " cannot divide " + num4 + " without remainder.");
        }
    }

    public static void handleFactorial() {
        System.out.println("Enter a number:");
        int num5 = scanner.nextInt();
        int factorialResult = calculateFactorial(num5);
        System.out.println("Factorial of " + num5 + " is: " + factorialResult);
    }

    public static void handleCombination() {
        System.out.println("Enter two numbers:");
        int num6 = scanner.nextInt();
        int num7 = scanner.nextInt();
        int combinationResult = calculateCombination(num6, num7);
        System.out.println("Combination of " + num6 + " and " + num7 + " is: " + combinationResult);
    }

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            System.out.println("Please enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    handleHCF();
                    break;
                case 2:
                    checkPrime();
                    break;
                case 3:
                    handleDivisibility();
                    break;
                case 4:
                    handleFactorial();
                    break;
                case 5:
                    handleCombination();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);
        scanner.close(); // Closing scanner to prevent resource leak
    }
}

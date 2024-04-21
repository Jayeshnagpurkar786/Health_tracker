import java.util.InputMismatchException;
import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.print("Enter your weight in kilograms: ");
            double weight = scanner.nextDouble();

            System.out.print("Enter your height (in meters or feet): ");
            double height = getInputHeight(scanner);

            double bmi = calculateBMI(weight, height);

            System.out.println("\nYour BMI is: " + bmi);

            displayBMICategoryAndAdvice(bmi, weight, height);

            System.out.print("\nDo you want to calculate BMI again? (yes/no): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("no")) {
                exit = true;
            }
        }

        scanner.close();
    }

    public static double getInputHeight(Scanner scanner) {
        double height;
        while (true) {
            try {
                System.out.print("Enter 'm' for meters or 'f' for feet and inches: ");
                String unit = scanner.next();
                if (unit.equalsIgnoreCase("m")) {
                    System.out.print("Enter your height in meters: ");
                    height = scanner.nextDouble();
                    break;
                } else if (unit.equalsIgnoreCase("f")) {
                    System.out.print("Enter feet: ");
                    double feet = scanner.nextDouble();
                    System.out.print("Enter inches: ");
                    int inches = scanner.nextInt();
                    height = convertFeetAndInchesToMeters(feet, inches);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'm' for meters or 'f' for feet and inches.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the scanner buffer
            }
        }
        return height;
    }

    public static double convertFeetAndInchesToMeters(double feet, int inches) {
        double totalInches = feet * 12 + inches;
        return totalInches * 0.0254; // 1 inch = 0.0254 meters
    }

    public static double calculateBMI(double weight, double height) {
        // BMI formula: weight (kg) / (height * height) (m^2)
        return weight / (height * height);
    }

    public static void displayBMICategoryAndAdvice(double bmi, double weight, double height) {
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
            double idealWeight = 18.5 * height * height;
            double weightToGain = idealWeight - weight;
            System.out.println("BMI Category: " + category);
            System.out.println("You are underweight. You may need to gain approximately " + weightToGain + " kilograms.");
        } else if (bmi < 24.9) {
            category = "Normal Weight";
            System.out.println("BMI Category: " + category);
            System.out.println("You are within the normal weight range. Keep up the good work!");
        } else if (bmi < 29.9) {
            category = "Overweight";
            double idealWeight = 24.9 * height * height;
            double weightToLose = weight - idealWeight;
            System.out.println("BMI Category: " + category);
            System.out.println("You are overweight. You may need to lose approximately " + weightToLose + " kilograms.");
        } else {
            category = "Obese";
            System.out.println("BMI Category: " + category);
            System.out.println("You are obese. Please consult a healthcare professional");
        }
    }
}

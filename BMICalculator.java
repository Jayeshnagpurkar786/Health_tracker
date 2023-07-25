import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);

        System.out.println("\nYour BMI is: " + bmi);

        displayBMICategory(bmi);

        scanner.close();
    }

    public static double calculateBMI(double weight, double height) {
        // BMI formula: weight (kg) / (height * height) (m^2)
        return weight / (height * height);
    }

    public static void displayBMICategory(double bmi) {
        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 24.9) {
            category = "Normal Weight";
        } else if (bmi < 29.9) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        System.out.println("BMI Category: " + category);
    }
}

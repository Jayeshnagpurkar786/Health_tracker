import java.util.Scanner;

class HealthTracker {
    private int steps;
    private double caloriesBurnedPerStep;

    public HealthTracker() {
        this.steps = 0;
        this.caloriesBurnedPerStep = 0.05 ; // Calories burned per step (adjust as needed)
    }

    public void addSteps(int steps) {
        this.steps += steps;
    }

    public int getSteps() {
        return steps;
    }

    public double getCalories() {
        return steps * caloriesBurnedPerStep;
    }
}

public class CaloriesBurned{
    public static void main(String[] args) {
        HealthTracker tracker = new HealthTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Health Tracker Menu:");
            System.out.println("1. Add steps");
            System.out.println("2. View total steps");
            System.out.println("3. View total calories burned");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the number of steps: ");
                    int steps = scanner.nextInt();
                    tracker.addSteps(steps);
                    System.out.println("Steps added successfully.");
                    break;
                case 2:
                    System.out.println("Total steps: " + tracker.getSteps());
                    break;
                case 3:
                    System.out.println("Total calories burned: " + tracker.getCalories());
                    break;
                case 4:
                    System.out.println("Exiting Health Tracker...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
}

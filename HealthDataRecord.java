import java.time.LocalDate;
import java.util.Scanner;

class HealthData {
    private LocalDate date;
    private int dailyStepCount;
    private int heartRate;
    private int systolicBloodPressure;
    private int diastolicBloodPressure;
    private int sleepDuration;
    private int caloricIntake;

    public HealthData(LocalDate date, int dailyStepCount, int heartRate, int systolicBloodPressure,
                      int diastolicBloodPressure, int sleepDuration, int caloricIntake) {
        this.date = date;
        this.dailyStepCount = dailyStepCount;
        this.heartRate = heartRate;
        this.systolicBloodPressure = systolicBloodPressure;
        this.diastolicBloodPressure = diastolicBloodPressure;
        this.sleepDuration = sleepDuration;
        this.caloricIntake = caloricIntake;
    }

    // Getters and setters for the health data properties
    // ...

    @Override
    public String toString() {
        return "Date: " + date +
               ", Steps: " + dailyStepCount +
               ", Heart Rate: " + heartRate +
               ", Blood Pressure: " + systolicBloodPressure + "/" + diastolicBloodPressure +
               ", Sleep Duration: " + sleepDuration +
               ", Caloric Intake: " + caloricIntake;
    }
}

public class HealthDataRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for health data
        System.out.print("Enter today's date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate date = LocalDate.parse(dateStr);

        System.out.print("Enter daily step count: ");
        int dailyStepCount = scanner.nextInt();

        System.out.print("Enter heart rate: ");
        int heartRate = scanner.nextInt();

        System.out.print("Enter systolic blood pressure: ");
        int systolicBloodPressure = scanner.nextInt();

        System.out.print("Enter diastolic blood pressure: ");
        int diastolicBloodPressure = scanner.nextInt();

        System.out.print("Enter sleep duration (in hours): ");
        int sleepDuration = scanner.nextInt();

        System.out.print("Enter caloric intake: ");
        int caloricIntake = scanner.nextInt();

        // Create a HealthData object with user input
        HealthData userHealthData = new HealthData(date, dailyStepCount, heartRate,
                                                   systolicBloodPressure, diastolicBloodPressure,
                                                   sleepDuration, caloricIntake);

        // Display the recorded health data
        System.out.println("\nRecorded Health Data:");
        System.out.println(userHealthData);

        

        scanner.close();
        
    }
}

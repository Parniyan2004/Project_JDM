import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("╔════════════════════════════════════╗");
            System.out.println("║  Welcome to the CMAS System        ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1. I am a Doctor                   ║");
            System.out.println("║ 2. I am a Patient                  ║");
            System.out.println("║ 0. Exit                            ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    // Doctor login + menu
                    try {
                        DoctorMenu.main(null);
                    } catch (Exception e) {
                        System.out.println("❌ Doctor system error: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Patient sub-menu
                    patientMenu(scanner);
                    break;

                case 0:
                    System.out.println("👋 Goodbye!");
                    break;

                default:
                    System.out.println(" Invalid option.");
            }

        } while (choice != 0);
    }

    private static void patientMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\nPatient Menu:");
            System.out.println("1. Add yourself as a new patient");
            System.out.println("2. Add CMAS test result");
            System.out.println("3. View your test results");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    try {
                        AddPatient.main(null);
                    } catch (Exception e) {
                        System.out.println(" Error adding patient: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        AddTestResult.main(null);
                    } catch (Exception e) {
                        System.out.println(" Error adding test result: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        ViewTestResults.main(null);
                    } catch (Exception e) {
                        System.out.println(" Error viewing results: " + e.getMessage());
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println(" Invalid option.");
            }

        } while (choice != 0);
    }
}
import java.sql.*;
import java.util.Scanner;

public class DoctorMenu {
    private static final String DB_URL = "jdbc:sqlite:database/cmas_data.db";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement loginStmt = conn.prepareStatement(
                    "SELECT * FROM Doctor WHERE email = ? AND password = ?");
            loginStmt.setString(1, email);
            loginStmt.setString(2, password);
            ResultSet rs = loginStmt.executeQuery();

            if (!rs.next()) {
                System.out.println(" Login failed. Invalid credentials.");
                return;
            }

            String doctorName = rs.getString("name");
            System.out.println("\n Login successful! Welcome, Dr. " + doctorName);

            int choice;
            do {
                // Main Menu
                System.out.println("\nMain Menu:");
                System.out.println("1. List all patients");
                System.out.println("2. View test results for a patient");
                System.out.println("3. Add test result");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // clear newline

                switch (choice) {
                    case 1:
                        listPatients(conn);
                        break;
                    case 2:
                        viewTestResults(scanner, conn);
                        break;
                    case 3:
                        addTestResult(scanner, conn);
                        break;
                    case 0:
                        System.out.println(" Goodbye!");
                        break;
                    default:
                        System.out.println(" Invalid choice.");
                }

            } while (choice != 0);

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    private static void listPatients(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Patient");

        System.out.println("\n👥 Patients:");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " +
                    rs.getString("name") + ", Birth Date: " + rs.getString("birth_date"));
        }
    }

    private static void viewTestResults(Scanner scanner, Connection conn) throws SQLException {
        System.out.print("Enter patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        PreparedStatement stmt = conn.prepareStatement(
                "SELECT * FROM TestResult WHERE patient_id = ? ORDER BY date");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        System.out.println("\n📊 Test Results:");
        boolean found = false;
        while (rs.next()) {
            found = true;
            System.out.println("Date: " + rs.getString("date") + " | CMAS Score: " + rs.getInt("score"));
        }

        if (!found) System.out.println("⚠ No test results found.");
    }

    private static void addTestResult(Scanner scanner, Connection conn) throws SQLException {
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter test date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter CMAS score (0-52): ");
        int score = scanner.nextInt();

        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO TestResult(patient_id, date, score) VALUES (?, ?, ?)");
        stmt.setInt(1, patientId);
        stmt.setString(2, date);
        stmt.setInt(3, score);
        stmt.executeUpdate();

        System.out.println("✅ Test result added successfully.");
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddTestResult {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/cmas_data.db";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // clear buffer

        System.out.print("Enter test date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter CMAS score (0–52): ");
        int score = scanner.nextInt();

        String sql = "INSERT INTO TestResult(patient_id, date, score) VALUES(?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, patientId);
            pstmt.setString(2, date);
            pstmt.setInt(3, score);

            pstmt.executeUpdate();
            System.out.println("✅ Test result added successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
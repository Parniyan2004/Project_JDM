import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewTestResults {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/cmas_data.db";
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter patient ID to view results: ");
            int patientId = scanner.nextInt();

            String sql = "SELECT date, score FROM TestResult WHERE patient_id = ? ORDER BY date";

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, patientId);
                ResultSet rs = pstmt.executeQuery();

                System.out.println("\n Test Results for Patient ID: " + patientId);
                System.out.println("---------------------------------------");

                boolean hasResults = false;
                while (rs.next()) {
                    hasResults = true;
                    String date = rs.getString("date");
                    int score = rs.getInt("score");

                    System.out.println("Date: " + date + " | CMAS Score: " + score);
                }

                if (!hasResults) {
                    System.out.println("No results found for this patient.");
                }

            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }
}
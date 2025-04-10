
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddPatient {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/cmas_data.db";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();

            System.out.print("Enter birth date (YYYY-MM-DD): ");
            String birthDate = scanner.nextLine();

            String sql = "INSERT INTO Patient(name, birth_date) VALUES(?, ?)";

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, name);
                pstmt.setString(2, birthDate);
                pstmt.executeUpdate();
                System.out.println(" Patient added successfully.");

            } catch (Exception e) {
                System.out.println("❌ Error: " + e.getMessage());
            }
        }
    }
}
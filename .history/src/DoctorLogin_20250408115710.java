import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DoctorLogin {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/cmas_data.db";
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            String sql = "SELECT * FROM Doctor WHERE email = ? AND password = ?";

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, email);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    System.out.println("Login successful! Welcome,  " + rs.getString("name"));
                    // You could continue here with options like "View Patients", etc.
                } else {
                    System.out.println("Login failed. Incorrect email or password.");
                }

            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }
}
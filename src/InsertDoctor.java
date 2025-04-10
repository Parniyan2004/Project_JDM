import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDoctor {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/cmas_data.db";
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter doctor's name: ");
            String name = scanner.nextLine();

            System.out.print("Enter doctor's email: ");
            String email = scanner.nextLine();

            System.out.print("Enter doctor's password: ");
            String password = scanner.nextLine();

            String sql = "INSERT INTO Doctor (name, email, password) VALUES (?, ?, ?)";

            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.executeUpdate();

                System.out.println(" Doctor inserted successfully.");

            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
            }
        }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListPatients {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/cmas_data.db";

        String sql = "SELECT id, name, birth_date FROM Patient";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("👥 List of Patients:");
            System.out.println("-----------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String birthDate = rs.getString("birth_date");

                System.out.println("ID: " + id + ", Name: " + name + ", Birth Date: " + birthDate);
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
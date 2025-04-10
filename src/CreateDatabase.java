import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database/cmas_data.db"; // Will be created in the "database" folder

        String createPatientTable = "CREATE TABLE IF NOT EXISTS Patient (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "birth_date TEXT NOT NULL);";

        String createTestResultTable = "CREATE TABLE IF NOT EXISTS TestResult (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "patient_id INTEGER NOT NULL," +
                "date TEXT NOT NULL," +
                "score INTEGER NOT NULL," +
                "FOREIGN KEY(patient_id) REFERENCES Patient(id));";

        String createDoctorTable = "CREATE TABLE IF NOT EXISTS Doctor (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "password TEXT NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createPatientTable);
            stmt.execute(createTestResultTable);
            stmt.execute(createDoctorTable);

            System.out.println(" Database and tables created successfully.");

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
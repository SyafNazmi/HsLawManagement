import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/sofea/sqlite/HSLawManagement.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Employees (\n"
                + " IDLaw text PRIMARY KEY,\n"
                + " FirstName text NOT NULL,\n"
                + " LastName text \n"
                + " Contact text \n"
                + " Position text \n"
                + " Salary text \n"
                + " IDCase text NOT NULL,\n"
                + " capacity real\n"
                + ");";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewTable();
    }

}

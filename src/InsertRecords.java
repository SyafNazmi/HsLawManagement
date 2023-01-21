import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/sofea/sqlite/HSLawManagement.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String IDLaw, String FirstName, String LastName,
                       String Contact, String Position, String Salary) {
        String sql = "INSERT INTO Employees(IDLaw, FirstName, LastName," +
                "Contact, Position, Salary) VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, IDLaw);
            pstmt.setString(2, FirstName);
            pstmt.setString(3, LastName);
            pstmt.setString(4, Contact);
            pstmt.setString(5, Position);
            pstmt.setString(6, Salary);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}




/*public static void main(String[] args)
{
    InsertRecords app = new InsertRecords();

    app.insert();
}*/

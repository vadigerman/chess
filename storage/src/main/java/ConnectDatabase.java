import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectDatabase {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        int result = 0;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/test2db", "SA", "");
            stmt = con.createStatement();

            result = stmt.executeUpdate("CREATE TABLE calculate_execution (" +
                    "exec_id INT NOT NULL, " +
                    "exec_time VARCHAR(50) NOT NULL, " +
                    "exec_res TIMESTAMP, " +
                    "PRIMARY KEY (exec_id));");

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("Table created successfully");
    }
}

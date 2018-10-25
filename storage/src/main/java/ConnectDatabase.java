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
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();

//            result = stmt.executeUpdate("DROP TABLE exec_combinations");
//            result = stmt.executeUpdate("DROP TABLE calculate_execution");

//            result = stmt.executeUpdate("CREATE TABLE calculate_execution (" +
//                    "execution_id INT NOT NULL, " +
//                    "execution_time INT NOT NULL, " +
//                    "execution_result INT NOT NULL, " +
//                    "PRIMARY KEY (execution_id));");

            result = stmt.executeUpdate("CREATE TABLE exec_combinations (" +
                    "execution_id INT NOT NULL, " +
                    "combination_path VARCHAR(100) NOT NULL, " +
                    "combination_number INT NOT NULL" +
//                    ", FOREIGN KEY (execution_id) REFERENCES calculate_execution (execution_id)" +
                    ");");

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("successfully");
    }
}

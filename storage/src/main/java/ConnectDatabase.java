import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDatabase {
//    public void updateExecution(long execTime, long combCnt) {
//        Connection con = null;
//        PreparedStatement statement = null;
//        try {
//            Class.forName("org.hsqldb.jdbc.JDBCDriver");
//            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
//            con.setAutoCommit(false);
//            statement = con.prepareStatement("INSERT INTO calculate_execution VALUES (?, ?, ?)");
////            statement.setLong(1, 1);
//            statement.setLong(2, execTime);
//            statement.setLong(3, combCnt);
//            statement.execute();
//            con.commit();
//        } catch (Exception e) {
//            e.printStackTrace(System.out);
//        }
//    }

    public static void main(String[] args) {
        try {
            int result;
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            Statement stmt = con.createStatement();

//            result = stmt.executeUpdate("DROP TABLE calculate_execution");
//            result = stmt.executeUpdate("DROP TABLE exec_combinations");

//            result = stmt.executeUpdate("CREATE TABLE calculate_execution (" +
//                    "execution_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
//                    "execution_time INT, " +
//                    "execution_result INT" +
//                    ");");

//            result = stmt.executeUpdate("CREATE TABLE exec_combinations (" +
//                    "execution_id INT NOT NULL, " +
//                    "combination_path VARCHAR(100) NOT NULL, " +
//                    "combination_number INT NOT NULL" +
//                    ", FOREIGN KEY (execution_id) REFERENCES calculate_execution (execution_id)" +
//                    ");");

            con.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        System.out.println("successful");
    }
}

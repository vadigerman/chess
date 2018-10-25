import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBStorage implements Storage {
    Connection con = null;
    Statement stmt = null;
    int result = 0;
    Connection con2 = null;
    Statement stmt2 = null;
    int result2 = 0;
    int count = 1;

    @Override
    public void savePath(String str, long number) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO exec_combinations VALUES ("+count+", '"+str+"', "+number+")");
            con.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void saveTime(long execTime, long combCnt) {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con2 = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt2 = con2.createStatement();
            result2 = stmt2.executeUpdate("INSERT INTO calculate_execution VALUES ("+count+", "+execTime+", "+combCnt+")");
            count++;
            con2.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}

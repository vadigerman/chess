import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBStorage implements Storage {
    @Override
    public long registerExecution() {
        Connection con;
        Statement stmt;
        ResultSet rs;
        int result;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO calculate_execution (execution_time, execution_result) VALUES (NULL, NULL)");
            rs = stmt.executeQuery("SELECT execution_id FROM calculate_execution WHERE execution_time IS NULL");
            if (rs.next()) {
                System.out.println(rs.getLong("execution_id"));
                return rs.getLong("execution_id");
            }
        } catch (Exception e) {
            //
        }
        return 0;
    }

    @Override
    public void savePath(List<Object[]> paths) {
        System.out.println("test");
        Connection con = null;
        PreparedStatement statement = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            con.setAutoCommit(false);
            statement = con.prepareStatement("INSERT INTO exec_combinations VALUES (?, ?, ?)");
            System.out.println("test-3");
            for (Object[] path : paths) {
                System.out.println(path);
                statement.setLong(1, (Long) path[0]);
                statement.setString(2, (String) path[1]);
                statement.setLong(3, (Long) path[2]);
                statement.addBatch();
            }
            statement.executeBatch();
            con.commit();
        } catch (SQLException e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    //
                }
            }
        } catch(ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    //
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    //
                }
            }
        }
    }

    @Override
    public void updateExecution(long execId, long execTime, long combCnt) {
        System.out.println("test-2");
        Connection con = null;
        PreparedStatement statement = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            con.setAutoCommit(false);
            statement = con.prepareStatement("UPDATE calculate_execution SET execution_time = ? AND execution_result = ? WHERE execution_id = ?");
            statement.setLong(1, execTime);
            statement.setLong(2, combCnt);
            statement.setLong(3, execId);
            statement.executeUpdate();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}

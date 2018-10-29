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
                return rs.getLong("execution_id");
            }
        } catch (Exception e) {
            //
        }
        return 0;
    }

    @Override
    public void savePath(List<PiecePaths> paths) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            con.setAutoCommit(false);
            statement = con.prepareStatement("INSERT INTO exec_combinations VALUES (?, ?, ?)");
            for (PiecePaths path : paths) {
                statement.setLong(1, path.getExecutionId());
                statement.setString(2, path.getPath());
                statement.setLong(3, path.getcNum());
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
        Connection con = null;
        PreparedStatement statement = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            con.setAutoCommit(false);
            statement = con.prepareStatement("UPDATE calculate_execution SET execution_time = ?, execution_result = ? WHERE execution_id = ?");
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

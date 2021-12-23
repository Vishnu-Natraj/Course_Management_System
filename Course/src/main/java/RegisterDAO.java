import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterDAO {
    String jdbcURL;
    String jdbcUserName;
    String jdbcPassword;
    Connection jdbcConnection;

    // Constructor
    public RegisterDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassword = jdbcPassword;
    }

    // Method to Establish the Connection
    void connect() throws Exception {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }
    }

    // Method to Disconnect the Connection

    void disconnect() throws Exception {
        if (jdbcConnection != null || !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    // method to add new data to db

    public boolean insertregister(Register insertregister) throws Exception {

        String sql = "INSERT INTO Register values(?,?,?,?)";

        connect();

        PreparedStatement prepstat = jdbcConnection.prepareStatement(sql);

        prepstat.setString(1, insertregister.getUsername());

        prepstat.setString(2, insertregister.getEmail_Address());

        prepstat.setString(3, insertregister.getPassword());

        prepstat.setString(4, insertregister.getConfirm_Password());

        boolean rowUpdated = prepstat.executeUpdate() > 0;

        prepstat.close();

        disconnect();

        return rowUpdated;

    }
}
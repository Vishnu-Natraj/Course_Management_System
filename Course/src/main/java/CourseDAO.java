import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    String jdbcURL;
    String jdbcUserName;
    String jdbcPassword;
    Connection jdbcConnection;

    // Constructor
    public CourseDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
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

    // Method to get all the data from the database
    public List<Course> ListAllCourse() throws Exception {

        List<Course> courseDaoList = new ArrayList<Course>();
        String sql = "SELECT * FROM Course";
        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int Course_id = resultSet.getInt("course_Id");
            String Department_name = resultSet.getString("department_name");
            String Start_date = resultSet.getString("start_date");
            String End_date = resultSet.getString("end_date");
            String No_of_Semester = resultSet.getString("no_of_semester");

            Course courseobj = new Course();

            courseobj.setCourse_Id(Course_id);
            courseobj.setDepartment_name(Department_name);
            courseobj.setStart_date(Start_date);
            courseobj.setEnd_date(End_date);
            courseobj.setno_of_semester(No_of_Semester);

            courseDaoList.add(courseobj);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return courseDaoList;

    }

    // method to add new data to db

    public boolean insertCourse(Course insertuser) throws Exception {

        String sql = "INSERT INTO Course values(?,?,?,?,?)";

        connect();

        PreparedStatement prepstat = jdbcConnection.prepareStatement(sql);

        prepstat.setInt(1, insertuser.getCourse_Id());

        prepstat.setString(2, insertuser.getDepartment_name());

        prepstat.setString(3, insertuser.getStart_date());

        prepstat.setString(4, insertuser.getEnd_date());

        prepstat.setString(5, insertuser.getno_of_semester());

        boolean rowUpdated = prepstat.executeUpdate() > 0;

        prepstat.close();

        disconnect();

        return rowUpdated;

    }
}

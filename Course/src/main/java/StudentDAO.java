import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    String jdbcURL;
    String jdbcUserName;
    String jdbcPassword;
    Connection jdbcConnection;

    // Constructor
    public StudentDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) {
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
    public List<Student> ListAllCourse() throws Exception {
        List<Student> StudentDaoList = new ArrayList<Student>();
        String sql = "SELECT * FROM STUDENT";
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("-------");

        while (resultSet.next()) {
            String student_id = resultSet.getString("Student_Id");
            String student_name = resultSet.getString("Student_name");
            int address_id = resultSet.getInt("address_id");
            int course_id = resultSet.getInt("course_id");
            int age = resultSet.getInt("age");
            String dob = resultSet.getString("dob");
            int fees = resultSet.getInt("fees");
            String gender = resultSet.getString("gender");
            String phone_number = resultSet.getString("phone_number");
            int mark_1 = resultSet.getInt("mark_1");
            int mark_2 = resultSet.getInt("mark_2");
            int mark_3 = resultSet.getInt("mark_3");
            String email = resultSet.getString("email");
            String attendance = resultSet.getString("attendance");
            int gpa = resultSet.getInt("gpa");
            
            Student obj = new Student(student_id, student_name, address_id, course_id, age, dob, fees,
                    gender, phone_number, mark_1, mark_2, mark_3, email, attendance, gpa);

            obj.setStudent_Id(student_id);
            obj.setStudent_name(student_name);
            obj.setAddress_Id(address_id);
            obj.setCourse_Id(course_id);
            obj.setAge(age);
            obj.setDOB(dob);
            obj.setFees(fees);
            obj.setGender(gender);
            obj.setPhone_Number(phone_number);
            obj.setMark_1(mark_1);
            obj.setMark_2(mark_2);
            obj.setMark_3(mark_3);
            obj.setEmail(email);
            obj.setAttendance(attendance);
            obj.setGPA(gpa);
            StudentDaoList.add(obj);
        }
        
        resultSet.close();
        statement.close();
        disconnect();
        return StudentDaoList;
    }

    // method to add new data to db
    public boolean insertStudent(Student insertuser) throws Exception {
        String sql = "INSERT INTO STUDENT values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connect();
        PreparedStatement prepstat = jdbcConnection.prepareStatement(sql);
        prepstat.setString(1, insertuser.getStudent_Id());
        prepstat.setString(2, insertuser.getStudent_name());
        prepstat.setInt(3, insertuser.getAddress_Id());
        prepstat.setInt(4, insertuser.getCourse_Id());
        prepstat.setInt(5, insertuser.getAge());
        prepstat.setString(6, insertuser.getDOB());
        prepstat.setInt(7, insertuser.getFees());
        prepstat.setString(8, insertuser.getGender());
        prepstat.setString(9, insertuser.getPhone_Number());
        prepstat.setInt(10, insertuser.getMark_1());
        prepstat.setInt(11, insertuser.getMark_2());
        prepstat.setInt(12, insertuser.getMark_3());
        prepstat.setString(13, insertuser.getEmail());
        prepstat.setString(14, insertuser.getAttendance());
        prepstat.setInt(15, insertuser.getGPA());
        boolean rowUpdated = prepstat.executeUpdate() > 0;
        prepstat.close();
        disconnect();
        return rowUpdated;
    }

   
}
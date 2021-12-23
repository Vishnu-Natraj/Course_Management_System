import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/Student")
public class StudentServlet extends HttpServlet {
    StudentDAO studentDAO;

    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://db4free.net/vishnu205";
        String jdbcUsername = "vishnu205040";
        String jdbcPassword = "vishnu205040";
        studentDAO = new StudentDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // ArrayList<Student> courselist = new ArrayList<Student>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> courselist = new ArrayList<Student>();
        try {
            courselist = studentDAO.ListAllCourse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Gson g = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String course1 = g.toJson(courselist);
        response.getWriter().print(course1);
        System.out.println(course1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post2 calling...");

        String requestData1 = req.getReader().lines().collect(Collectors.joining());

        // json obj is converted to java obj

        Student newuser = new Gson().fromJson(requestData1, Student.class);

        System.out.println("requestData Length->" + requestData1.length());

        System.out.println("requestData->" + requestData1);

        try {
            studentDAO.insertStudent(newuser);
        } catch (Exception e) {

            e.printStackTrace();

            // TODO: handle exception

        }

    }

}

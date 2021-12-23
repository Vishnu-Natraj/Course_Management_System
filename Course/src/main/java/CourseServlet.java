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

@WebServlet("/Course")
public class CourseServlet extends HttpServlet {
    CourseDAO courseDAO;

    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://db4free.net/vishnu205";
        String jdbcUsername = "vishnu205040";
        String jdbcPassword = "vishnu205040";
        courseDAO = new CourseDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // ArrayList<Course> courselist = new ArrayList<Course>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Course> courselist = new ArrayList<Course>();
        try {
            courselist = courseDAO.ListAllCourse();
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
        System.out.println("Post calling...");
        String requestData = req.getReader().lines().collect(Collectors.joining());

        // json obj is converted to java obj

        Course newuser = new Gson().fromJson(requestData, Course.class);

        System.out.println("requestData Length->" + requestData.length());

        System.out.println("requestData->" + requestData);

        try {
    
            courseDAO.insertCourse(newuser);

        } catch (Exception e) {

            e.printStackTrace();

            
        }

    }

}

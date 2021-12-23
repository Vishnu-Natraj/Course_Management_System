import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import java.util.stream.Collectors;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    RegisterDAO registerDAO;

    public void init() throws ServletException {
        String jdbcURL = "jdbc:mysql://db4free.net/vishnu205";
        String jdbcUsername = "vishnu205040";
        String jdbcPassword = "vishnu205040";
        registerDAO = new RegisterDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // adding to database
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post calling...");
        String requestData2 = req.getReader().lines().collect(Collectors.joining());

        // json obj is converted to java obj

        Register newregister = new Gson().fromJson(requestData2, Register.class);

        System.out.println("requestData Length->" + requestData2.length());

        System.out.println("requestData->" + requestData2);

        try {

            registerDAO.insertregister(newregister);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
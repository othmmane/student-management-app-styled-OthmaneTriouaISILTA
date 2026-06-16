package isil.est.essaouira.servlet;

import isil.est.essaouira.dao.StudentDAO;
import isil.est.essaouira.dao.StudentDAOImpl;
import isil.est.essaouira.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for adding a new student.
 * GET  /students/add  -> show form
 * POST /students/add  -> save student
 */
@WebServlet("/students/add")
public class StudentAddServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/add-student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        if (isBlank(firstName) || isBlank(lastName) || isBlank(email)) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/views/add-student.jsp").forward(request, response);
            return;
        }

        try {
            studentDAO.save(new Student(firstName, lastName, email));
            response.sendRedirect(request.getContextPath() + "/students");
        } catch (SQLException e) {
            request.setAttribute("error", "Database error while adding student. Maybe email already exists.");
            request.getRequestDispatcher("/views/add-student.jsp").forward(request, response);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

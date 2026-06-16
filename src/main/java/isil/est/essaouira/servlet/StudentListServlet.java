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
import java.util.List;

/**
 * Controller for listing students.
 * URL: GET /students
 */
@WebServlet("/students")
public class StudentListServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> students = studentDAO.findAll();
            request.setAttribute("students", students);
            request.getRequestDispatcher("/views/students.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Database error while listing students", e);
        }
    }
}

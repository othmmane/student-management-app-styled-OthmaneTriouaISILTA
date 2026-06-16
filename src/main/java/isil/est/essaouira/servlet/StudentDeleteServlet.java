package isil.est.essaouira.servlet;

import isil.est.essaouira.dao.StudentDAO;
import isil.est.essaouira.dao.StudentDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controller for deleting a student.
 * POST /students/delete
 */
@WebServlet("/students/delete")
public class StudentDeleteServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            studentDAO.delete(id);
            response.sendRedirect(request.getContextPath() + "/students");
        } catch (NumberFormatException | SQLException e) {
            throw new ServletException("Error while deleting student", e);
        }
    }
}

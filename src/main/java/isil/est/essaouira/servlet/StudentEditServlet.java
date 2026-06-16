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
 * Controller for editing a student.
 * GET  /students/edit?id=1  -> show form with old values
 * POST /students/edit       -> update student
 */
@WebServlet("/students/edit")
public class StudentEditServlet extends HttpServlet {

    private final StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = studentDAO.findById(id);

            if (student == null) {
                response.sendRedirect(request.getContextPath() + "/students");
                return;
            }

            request.setAttribute("student", student);
            request.getRequestDispatcher("/views/edit-student.jsp").forward(request, response);
        } catch (NumberFormatException | SQLException e) {
            throw new ServletException("Error while loading student for edit", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            if (isBlank(firstName) || isBlank(lastName) || isBlank(email)) {
                Student student = new Student(id, firstName, lastName, email);
                request.setAttribute("student", student);
                request.setAttribute("error", "All fields are required.");
                request.getRequestDispatcher("/views/edit-student.jsp").forward(request, response);
                return;
            }

            studentDAO.update(new Student(id, firstName, lastName, email));
            response.sendRedirect(request.getContextPath() + "/students");
        } catch (NumberFormatException | SQLException e) {
            throw new ServletException("Error while updating student", e);
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}

package isil.est.essaouira.dao;

import isil.est.essaouira.model.Student;
import isil.est.essaouira.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO Implementation = real database work.
 * This class contains JDBC and SQL queries.
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT id, first_name, last_name, email FROM students ORDER BY id";

        // try-with-resources closes Connection, PreparedStatement and ResultSet automatically.
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // ResultSet contains rows returned by MySQL.
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email")
                );
                students.add(student);
            }
        }

        return students;
    }

    @Override
    public Student findById(int id) throws SQLException {
        String sql = "SELECT id, first_name, last_name, email FROM students WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            // ? number 1 receives the id parameter.
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email")
                    );
                }
            }
        }

        return null;
    }

    @Override
    public void save(Student student) throws SQLException {
        String sql = "INSERT INTO students (first_name, last_name, email) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(Student student) throws SQLException {
        String sql = "UPDATE students SET first_name = ?, last_name = ?, email = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

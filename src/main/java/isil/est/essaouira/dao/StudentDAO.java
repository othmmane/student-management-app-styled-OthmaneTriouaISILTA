package isil.est.essaouira.dao;

import isil.est.essaouira.model.Student;
import java.sql.SQLException;
import java.util.List;

/**
 * DAO Interface = contract.
 * It only says what operations must exist.
 * It does NOT contain SQL code.
 */
public interface StudentDAO {

    List<Student> findAll() throws SQLException;

    Student findById(int id) throws SQLException;

    void save(Student student) throws SQLException;

    void update(Student student) throws SQLException;

    void delete(int id) throws SQLException;
}

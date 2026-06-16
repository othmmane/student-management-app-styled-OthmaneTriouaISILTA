package isil.est.essaouira.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class responsible for creating a database connection.
 * DBConnection only opens the connection. It does NOT execute SQL queries.
 */
public class DBConnection {

    public static Connection getConnection() throws SQLException {
        // Explicitly load MySQL driver. Useful with Tomcat + Docker.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
        }

        // These values come from docker-compose.yml environment variables.
        String host = System.getenv().getOrDefault("DB_HOST", "localhost");
        String port = System.getenv().getOrDefault("DB_PORT", "3306");
        String dbName = System.getenv().getOrDefault("DB_NAME", "student_db");
        String user = System.getenv().getOrDefault("DB_USER", "student_user");
        String password = System.getenv().getOrDefault("DB_PASSWORD", "student_pass");

        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        return DriverManager.getConnection(url, user, password);
    }
}

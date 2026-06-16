CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE
);

INSERT INTO students (first_name, last_name, email) VALUES
('Othman', 'Trioua', 'othman@example.com'),
('Khalid', 'El Amrani', 'khalid@example.com'),
('Sara', 'Bennani', 'sara@example.com');

package isil.est.essaouira.model;

/**
 * POJO / Model / Entity class.
 * This class represents ONE student in Java.
 * In the database, it corresponds to ONE row in the students table.
 */
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;

    // Empty constructor required by many Java/JEE tools.
    public Student() {
    }

    // Constructor used when reading a complete student from database.
    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Constructor used before INSERT, because MySQL generates id automatically.
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

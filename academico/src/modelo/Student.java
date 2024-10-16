package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static void insertStudent(Student student) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO students (id, name, email) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Student> getAllStudents() {
        Connection con = connection.getConnection();
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


}

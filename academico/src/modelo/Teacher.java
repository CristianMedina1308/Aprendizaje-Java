package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String name;
    private String role;

    public Teacher(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public static void insertTeacher(Teacher teacher) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO teachers (id, name, role) VALUES (?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, teacher.getId());
            statement.setString(2, teacher.getName());
            statement.setString(3, teacher.getRole());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Teacher> getAllTeachers() {
        Connection con = connection.getConnection();
        List<Teacher> teachers = new ArrayList<>();

        String sql = "SELECT * FROM teachers";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Teacher teacher = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role")
                );
                teachers.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}

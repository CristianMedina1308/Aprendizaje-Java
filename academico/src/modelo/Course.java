package modelo;

import db.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    private String content;
    private boolean status;
    private int teacherId;

    public Course(int id, String name, String content, boolean status, int teacherId) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.status = status;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public boolean getStatus() {
        return status;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public static void insertCourse(Course course) {
        Connection con = connection.getConnection();

        String sql = "INSERT INTO courses (id, name, content, status, teacher_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, course.getId());
            statement.setString(2, course.getName());
            statement.setString(3, course.getContent());
            statement.setBoolean(4, course.getStatus());
            statement.setInt(5, course.getTeacherId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Course> getAllCourses() {
        Connection con = connection.getConnection();
        List<Course> courses = new ArrayList<>();

        String sql = "SELECT * FROM courses";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                Course course = new Course(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("content"),
                        rs.getBoolean("status"),
                        rs.getInt("teacher_id")
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
}

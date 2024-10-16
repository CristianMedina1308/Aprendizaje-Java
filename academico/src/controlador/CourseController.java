package controlador;

import modelo.Course;
import vista.ViewCourse;

import java.util.List;

public class CourseController {
    private ViewCourse view;

    public CourseController(ViewCourse view) {
        this.view = view;
    }

    public void insertNewCourse(Course newCourse) {
        Course.insertCourse(newCourse);
        view.mostrarMensaje("\nCurso guardado correctamente!");
    }

    public void displayAllCourses() {
        List<Course> courses = Course.getAllCourses();
        view.displayListCourses(courses);
    }
}

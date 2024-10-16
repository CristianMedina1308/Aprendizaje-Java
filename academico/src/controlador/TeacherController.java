package controlador;

import modelo.Teacher;
import vista.ViewTeacher;

import java.util.List;

public class TeacherController {
    private ViewTeacher view;

    public TeacherController(ViewTeacher view) {
        this.view = view;
    }

    public void insertNewTeacher(Teacher newTeacher) {
        Teacher.insertTeacher(newTeacher);
        view.mostrarMensaje("\nProfesor guardado correctamente!");
    }

    public void displayAllTeachers() {
        List<Teacher> teachers = Teacher.getAllTeachers();
        view.displayListTeachers(teachers);
    }
}

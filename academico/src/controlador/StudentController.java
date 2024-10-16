package controlador;

import modelo.Student;
import vista.ViewStudent;

import java.util.List;

public class StudentController {
    private ViewStudent view;

    public StudentController(ViewStudent view) {
        this.view = view;
    }

    public void insertNewStudent(Student newStudent) {
        Student.insertStudent(newStudent);
        view.mostrarMensaje("\nEstudiante guardado correctamente!");
    }

    public void displayAllStudents() {
        List<Student> students = Student.getAllStudents();
        view.displayListStudents(students);
    }
}

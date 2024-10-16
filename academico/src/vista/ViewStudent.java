package vista;

import interfaces.IMostrarMensaje;
import modelo.Student;

import java.util.List;

public class ViewStudent implements IMostrarMensaje {
    public void displayListStudents(List<Student> students) {
        System.out.println(" == Lista de estudiantes == ");
        for (Student student : students) {
            System.out.println("Id Estudiante: " + student.getId() + ", Nombre: " + student.getName() + ", Correo: " + student.getEmail());
        }
    }
}
